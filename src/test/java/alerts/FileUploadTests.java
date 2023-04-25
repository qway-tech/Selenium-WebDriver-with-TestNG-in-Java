package alerts;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.FileUploadPage;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {

    @Test
    public void testFileUpload(){
        FileUploadPage uploadPage = homePage.clickFileUploadLink();
        uploadPage.uploadFile("/Users/daniel.castro/Documents/DC/KODEOUT/QWay/PMQ_1/WebDriver_Java_PMQ_1/resources/chromedriver");
        assertEquals(uploadPage.getUploadedFiles(), "chromedriver","Uploaded files incorrect");
    }
}
