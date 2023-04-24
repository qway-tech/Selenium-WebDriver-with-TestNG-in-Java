package alerts;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.AlertsPage;
import static org.testng.Assert.assertEquals;

public class AlertTests extends BaseTests {

    @Test
    public void testAcceptAlert(){
        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.acceptAlert();
        assertEquals(alertsPage.getResult(), "You successfully clicked an alert", "Results text incorrect");
    }

    @Test
    public void testGetTextFromAlert(){
        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerConfirm();
        String text = alertsPage.getAlertText();
        alertsPage.dismissAlert();
        assertEquals(text, "I am a JS Confirm", "Alert text incorrect");
    }

    @Test
    public void testSetInputInAlert(){
        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerPrompt();
        String text = "Q.Way!";
        alertsPage.setAlertInputText(text);
        alertsPage.acceptAlert();
        assertEquals(alertsPage.getResult(), "You entered: " + text, "Results text incorrect");
    }
}
