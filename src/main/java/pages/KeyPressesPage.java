package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage {
    //Variáveis e Objetos
    private WebDriver driver;
    private By inputField = By.id("target");
    private By resultText = By.id("result");

    // Métodos
    public KeyPressesPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterText(String text){
        driver.findElement(inputField).sendKeys(text);
    }

    public void enterPi(){
        enterText(Keys.chord(Keys.ALT, "p") + "=3.14");
    }

    public String getInputTextLastKey(){
        String inputTextLastKey = driver.findElement(inputField).getAttribute("value");
        return inputTextLastKey.substring(inputTextLastKey.length()-1);
    }

    public String getResult() {
        return driver.findElement(resultText).getText();
    }
}
