package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
public class HorizontalSlider {
    private WebDriver driver;
    private By sliderContainer = By.cssSelector(".sliderContainer input");
    private By range = By.id("range");

    public HorizontalSlider(WebDriver driver) {
        this.driver = driver;
    }
    public void clickSlider() {
        WebElement slider = driver.findElement(sliderContainer);
        slider.click();
    }
    public void moveSliderRight(int clicks) {
        WebElement slider = driver.findElement(sliderContainer);
        for (int i = 0; i < clicks; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
    }
    public void moveSliderLeft(int clicks) {
        WebElement slider = driver.findElement(sliderContainer);
        for (int i = 0; i < clicks; i++) {
            slider.sendKeys(Keys.ARROW_LEFT);
        }
    }
    public String getSliderValue() {
        WebElement rangeElement = driver.findElement(range);
        String text = rangeElement.getText();
        return text;
    }

}
