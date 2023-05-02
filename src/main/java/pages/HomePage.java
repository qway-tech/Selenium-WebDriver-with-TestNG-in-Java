package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage {
    private WebDriver driver;
    public HomePage (WebDriver driver){
        this.driver = driver;
    }
    public void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }
    public ContextMenu clickFormContextMenu(){
        clickLink("Context Menu");
        return new ContextMenu(driver);
    }
    public HorizontalSlider clickFormHorizontalSlider(){
        clickLink("Horizontal Slider");
        return new HorizontalSlider(driver);
    }
}
