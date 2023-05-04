package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
public class ContextMenu {
    private WebDriver driver;
    public ContextMenu(WebDriver driver) {
        this.driver = driver;
    }
    public void clickHotSpot(){
        WebElement box = driver.findElement(By.id("hot-spot"));
        Actions action = new Actions(driver);
        action.contextClick(box).perform();
    }
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }
}
