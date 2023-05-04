package contextmenu;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ContextMenu;

import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {
    @Test
    public void testContextMenu(){
        ContextMenu contextMenu = homePage.clickFormContextMenu();
        contextMenu.clickHotSpot();
        String textAlert = contextMenu.getAlertText();
        contextMenu.acceptAlert();
        assertEquals(textAlert,"You selected a context menu", "Results text incorrect");
    }

}
