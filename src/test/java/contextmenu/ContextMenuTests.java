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
        contextMenu.acceptAlert();
    }

}
