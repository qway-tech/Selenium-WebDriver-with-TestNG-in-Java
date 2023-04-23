package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPage {
    //Variáveis e Objetos
    private WebDriver driver;
    private By figureBox = By.className("figure");
    private By captionBox = By.className("figcaption");

    public HoversPage(WebDriver driver){
        this.driver = driver;
    }

    public FigureCaption hoverOverFigure(int index){
        WebElement figure = driver.findElements(figureBox).get(index - 1);
        Actions actions = new Actions (driver);
        actions.moveToElement(figure).perform();
        return new FigureCaption(figure.findElement(captionBox));
    }

    public class  FigureCaption {
        private WebElement captionInstance;
        private By header = By.tagName("h5");
        private By link = By.tagName("a");

        public FigureCaption (WebElement caption) {
            this.captionInstance = caption;
        }

        public Boolean isCaptionDisplayed() {
            return captionInstance.isDisplayed();
        }

        public String getTitle() {
            return captionInstance.findElement(header).getText();
        }

        public String getLink() {
            return captionInstance.findElement(link).getAttribute("href");
        }

        public String getLinkText() {
            return captionInstance.findElement(link).getText();
        }
    }

}
