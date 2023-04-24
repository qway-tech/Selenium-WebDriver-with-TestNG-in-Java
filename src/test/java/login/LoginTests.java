package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;
import static org.testng.Assert.*;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfulLogin(){
        LoginPage loginPage = homePage.clickFormAuthenticationLink();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        assertTrue(
            secureAreaPage.getAlertText()
                    .contains("You logged into a secure area!"),
            "Alert text is incorrect");
    }

    @Test
    public void testFailedLogin(){
        LoginPage loginPage = homePage.clickFormAuthenticationLink();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        assertTrue(
            secureAreaPage.getAlertText()
                    .contains("Your username is invalid!"),
            "Alert text is incorrect");
    }
}
