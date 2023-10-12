package org.ait.demoqa.pages.elements;

import org.ait.demoqa.pages.BasePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class UploadPage extends BasePage {
    public UploadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "uploadFile")
    WebElement uploadFile;

    public UploadPage performKeyEventWithRobot() {
        pause(1000);
        clickWithRectangle(uploadFile, 2, 3);
        pause(30000);
        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);

        }
        robot.keyPress(KeyEvent.VK_SHIFT); //удерживаем Shift
        pause(1000);
        robot.keyPress(KeyEvent.VK_D); //удерживаем Shift
        robot.keyRelease(KeyEvent.VK_SHIFT); //отпускаем Shift
        robot.keyPress(KeyEvent.VK_1); //
        robot.keyPress(KeyEvent.VK_PERIOD); //
        robot.keyPress(KeyEvent.VK_T); //
        robot.keyPress(KeyEvent.VK_X); //
        robot.keyPress(KeyEvent.VK_T); //
        robot.keyPress(KeyEvent.VK_ENTER); //
        return this;
    }

    //@FindBy(id = "uploadedFilePath")
    WebElement uploadedFilePath;
    public UploadPage assertPath(String path) {
        Assert.assertTrue(isTextPresent(uploadedFilePath, path));
        return this;
    }


    public UploadPage performMauseEvent() {
        pause(1000);
        clickWithRectangle(uploadFile, 2, 3);
        pause(30000);
        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        Dimension dimension = driver.manage().window().getSize();
        System.out.println("Dimension x and y: " + dimension.getWidth() + " " + dimension.getHeight());
        int x = 303;
        int y = 496;
        //303 496
        pause(1000);
        //click left mouse button
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        //release left mouse button
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        pause(1000);
        //press ENTER key
        robot.keyPress(KeyEvent.VK_ENTER);
        return this;
    }
}
