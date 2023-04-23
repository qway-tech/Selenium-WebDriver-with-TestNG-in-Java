package hover;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HoversPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HoverTests extends BaseTests {

    @Test
    public void testHoverUser1(){
        HoversPage hoversPage = homePage.clickHoversLink();
        HoversPage.FigureCaption caption = hoversPage.hoverOverFigure(1);
        assertTrue(caption.isCaptionDisplayed());
        assertEquals(caption.getTitle(),"name: user1","Caption not displayed");
        assertEquals(caption.getLinkText(),"View profile","Caption link text incorrect");
        assertTrue(caption.getLink().endsWith("/users/1"),"Link incorrect");
    }

    @Test
    public void testHoverUser2(){
        HoversPage hoversPage = homePage.clickHoversLink();
        HoversPage.FigureCaption caption = hoversPage.hoverOverFigure(2);
        assertTrue(caption.isCaptionDisplayed());
        assertEquals(caption.getTitle(),"name: user2","Caption not displayed");
        assertEquals(caption.getLinkText(),"View profile","Caption link text incorrect");
        assertTrue(caption.getLink().endsWith("/users/2"),"Link incorrect");
    }

    @Test
    public void testHoverUser3(){
        HoversPage hoversPage = homePage.clickHoversLink();
        HoversPage.FigureCaption caption = hoversPage.hoverOverFigure(3);
        assertTrue(caption.isCaptionDisplayed());
        assertEquals(caption.getTitle(),"name: user3","Caption not displayed");
        assertEquals(caption.getLinkText(),"View profile","Caption link text incorrect");
        assertTrue(caption.getLink().endsWith("/users/3"),"Link incorrect");
    }
}
