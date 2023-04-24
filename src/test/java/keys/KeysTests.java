package keys;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.KeyPressesPage;
import static org.testng.Assert.assertEquals;

public class KeysTests extends BaseTests {

    @Test
    public void testBackspace(){
        KeyPressesPage keyPressesPage = homePage.clickKeyPressesLink();
        keyPressesPage.enterPi();
        assertEquals(keyPressesPage.getResult(),"You entered: BACK_SPACE");
    }

    @Test
    public void testPi(){
        KeyPressesPage keyPressesPage = homePage.clickKeyPressesLink();
        keyPressesPage.enterPi();
        String inputTextLastKey = keyPressesPage.getInputTextLastKey();
        assertEquals(keyPressesPage.getResult(),"You entered: " + inputTextLastKey);
    }
}
