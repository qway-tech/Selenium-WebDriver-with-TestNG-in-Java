package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.HomePage;

public class BaseTests {
    public WebDriver driver;
    protected HomePage homePage;
    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars","--remote-allow-origins=*","no-sandbox");
        return options;
    }
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver(getChromeOptions());
    }
    @AfterClass
    public void tearDown(){
        System.out.println("### Encerrando o driver...");
        driver.quit();
    }

    @BeforeMethod
    public void goHome(){
        String URL = "https://the-internet.herokuapp.com/";
        System.out.println("### Acessando \"" + URL + "\" ...");
        driver.get(URL);
        homePage = new HomePage(driver);
    }

}
