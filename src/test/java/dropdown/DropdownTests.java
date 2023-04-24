package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DropdownPage;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTests extends BaseTests {

    @Test
    public void testSelectedOptions(){
        DropdownPage dropdownPage = homePage.clickDropDownLink();
        String option = "Option 1";
        dropdownPage.selectFromDropdown(option);
        List selectedOptions = dropdownPage.getSelectedOptions();
        int selectedOptionsAmount = selectedOptions.size();
        assertEquals(selectedOptionsAmount, 1,"Wrong selected options amount: " + selectedOptionsAmount);
        assertTrue(selectedOptions.contains(option), "Option not selected");
    }
}
