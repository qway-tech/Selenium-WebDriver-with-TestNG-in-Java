package base;

import com.google.common.io.Files;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.io.File;
import java.util.Date;

public class BaseTests {

    private EventFiringWebDriver driver;
    public HomePage homePage;

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars","--remote-allow-origins=*","no-sandbox");
        options.setHeadless(false);
        return options;
    }

    private void setCookie(String name, String value){
        Cookie cookie = new Cookie.Builder(name, value)
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    public void pause (int ms) {
        try{Thread.sleep(ms);} catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeMethod
    public void goHome(){
        String URL = "https://the-internet.herokuapp.com/";
        driver.get(URL);
        homePage = new HomePage(driver);
        setCookie("qway", "123");
    }

    @AfterMethod
    public void takeScreenshot(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE) {
            // Capturando o screenshot em um arquivo
            TakesScreenshot camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);

            // Receber "package.className" do teste que falhou
            String packageAndClassNames = result.getTestClass().getName();
            int separatorIndex = packageAndClassNames.lastIndexOf(".");
            // Separando "package"
            String packageName = packageAndClassNames.substring(0,separatorIndex);
            // Separando "className" e juntando com "testName"
            String classAndTestName = packageAndClassNames.substring(separatorIndex + 1) + "." + result.getName();
            // Cria o diretório com o packageName
            String directoryPath = "resources/screenshots/" + packageName;
            File directory = new File(directoryPath);
            if (!directory.exists()) {directory.mkdir();}

            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy_HHmmss");
            String dateAndTime =  dateFormat.format(date);

            String fileTarget = directoryPath + "/" + classAndTestName + "_" + dateAndTime + ".png";

            try {
                Files.move(screenshot, new File(fileTarget));
                System.out.println("Test Failed: " + classAndTestName);
                System.out.println("... Screenshot taken: " + fileTarget);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @AfterClass
    public void tearDown() {
        System.out.println("### Encerrando o driver...");
        driver.quit();
    }
}