package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage {
    //Variáveis e Objetos
    private WebDriver driver;
    private String editorIframeId = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By increaseIndentButton = By.cssSelector("button[title='Increase indent']");

    // Métodos
    public WysiwygEditorPage(WebDriver driver){
        this.driver = driver;
    }

    // Alternar o contexto do driver para o iFrame
    private void switchToEditArea(){
        driver.switchTo().frame(editorIframeId);
    }

    public void clearTextArea(){
        switchToEditArea();
        driver.findElement(textArea).clear();
        switchToMainArea();
    }

    private void switchToMainArea(){
        driver.switchTo().parentFrame();
    }

    public void setTextArea(String text){
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }

    public void increaseIndent(){
        driver.findElement(increaseIndentButton).click();
    }

    public String getTextFromEditor(){
        switchToEditArea();
        String text = driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }
}
