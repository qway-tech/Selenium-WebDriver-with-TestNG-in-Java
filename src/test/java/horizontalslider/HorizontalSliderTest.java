package horizontalslider;
import base.BaseTests;
import org.testng.annotations.Test;
import pages.HorizontalSlider;

public class HorizontalSliderTest extends BaseTests {
    @Test
    public void MoveSlider() {
        HorizontalSlider horizontalSlider = homePage.clickFormHorizontalSlider();
        horizontalSlider.moveSlider("right", 3);
        System.out.println("Slider value Right: " + horizontalSlider.getSliderValue());
        horizontalSlider.moveSlider("left", 1);
        System.out.println("Slider value Left: " + horizontalSlider.getSliderValue());
    }
}
