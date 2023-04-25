package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {
    //Variáveis e Objetos
    private WebDriver driver;
    private By inputField = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By uploadedFile = By.id("uploaded-files");

    // Métodos
    public FileUploadPage(WebDriver driver){
        this.driver = driver;
    }

    // Enviando o path do arquivo para o input field
    public void uploadFile(String absolutePathOfFile){
        driver.findElement(inputField).sendKeys(absolutePathOfFile);
        clickUploadButton();
    }

    public void clickUploadButton(){
        driver.findElement(uploadButton).click();
    }

    public String getUploadedFiles(){
        String uploadedFileText = driver.findElement(uploadedFile).getText();
        return uploadedFileText;
    }
}
