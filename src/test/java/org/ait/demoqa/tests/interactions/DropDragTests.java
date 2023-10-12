package org.ait.demoqa.tests.interactions;

import org.ait.demoqa.interactions.DropablePage;
import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.pages.SidePanel;
import org.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDragTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getInteractions();
        new SidePanel(driver).selectDropable().hideIframes();
    }

    @Test
    public void dragMeTest(){
        new DropablePage(driver).actionDragMe()
                .assertDropped("Dropped");
    }

    @Test
    public void dragMeByTest(){
        new DropablePage(driver).actionDragMeBy(25,55)
                .assertDropped("Dropped");
    }


}
