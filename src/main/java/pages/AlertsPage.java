package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {
    //Variáveis e Objetos
    private WebDriver driver;
    private By triggerAlertButton = By.xpath(".//button[text()='Click for JS Alert']");
    private By triggerConfirmButton = By.xpath(".//button[text()='Click for JS Confirm']");
    private By triggerPromptButton = By.xpath(".//button[text()='Click for JS Prompt']");
    private By results = By.id("result");

    // Métodos
    public AlertsPage(WebDriver driver){
        this.driver = driver;
    }

    // Clicando no botão que dispara o JS Alert
    public void triggerAlert(){
        driver.findElement(triggerAlertButton).click();
    }

    // Clicando em OK no Alert
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    // Obtendo o texto do Alert
    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }

    // Obtendo o texto de resultado da página Java Script Alerts
    public String getResult(){
        return driver.findElement(results).getText();
    }

    // Clicando no botão que dispara o JS Corfirm
    public void triggerConfirm(){
        driver.findElement(triggerConfirmButton).click();
    }

    // Clicando em Cancel
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    // Clicando no botão que dispara o JS Prompt
    public void triggerPrompt(){
        driver.findElement(triggerPromptButton).click();
    }

    // Digitando texto no JS Prompt
    public void setAlertInputText(String text){
        driver.switchTo().alert().sendKeys(text);
    }
}
