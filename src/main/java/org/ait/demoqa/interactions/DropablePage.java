package org.ait.demoqa.interactions;

import org.ait.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DropablePage extends BasePage {

    public DropablePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "draggable")
    WebElement dragMe;
    @FindBy(id = "droppable")
    WebElement dropHere;

    public DropablePage actionDragMe() {
        pause(1000);
        new Actions(driver).dragAndDrop(dragMe, dropHere).perform();
        return this;
    }

    public DropablePage assertDropped(String text) {
        Assert.assertTrue(isTextPresent(dropHere, text));
        return this;
    }

    public DropablePage actionDragMeBy(int x, int y) {
        pause(1000);
        int xOffset1 = dragMe.getLocation().getX();
        int yOffSet1 = dragMe.getLocation().getY();
        System.out.println("xOffset1 --> " + xOffset1 + "yOffset1 --> " + yOffSet1);
        int xOffSet = dropHere.getLocation().getX();
        int yOffSet = dropHere.getLocation().getY();
        xOffSet = (xOffSet - xOffset1) + x;
        yOffSet = (yOffSet - yOffSet1) + y;
        System.out.println("xOffset --> " + xOffSet + "yOffset --> " + yOffSet);

        new Actions(driver).dragAndDropBy(dragMe, xOffSet, yOffSet).perform();
        return this;
    }
}
