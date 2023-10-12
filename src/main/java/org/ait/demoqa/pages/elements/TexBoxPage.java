package org.ait.demoqa.pages.elements;

import org.ait.demoqa.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class TexBoxPage extends BasePage {
    public TexBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "submit")
    WebElement submit;

    public TexBoxPage submit () {
        click(submit);
        return this;
    }


    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    public TexBoxPage keyBoardEvant(String text) {
        typeWithJSExecutor(currentAddress, text, 0, 100);

        Actions actions = new Actions(driver);
        //select copy  Tab paste
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        submit();
        return this;
    }


  /*@FindBy(css = ".border > #currentAddress")
    WebElement currentAddressResult;

    @FindBy(css = ".border > #permanentAddress")
    WebElement permanentAddressResult;

   public TextBoxPage assertCopyPastText() {
       String[] current =  currentAddressResult.getText().split(":");
       String[] permanent =  permanentAddressResult.getText().split(":");

       Assert.assertEquals(permanent[1],current[1]);
       return this;
    }*/
    @FindBy(xpath = "//p[@id='permanentAddress' and contains(text(), 'Permananet Address :')]")
    WebElement permanentAddressResult;
    @FindBy(xpath = "//p[@id='currentAddress' and contains(text(), 'Current Address :')]")
    WebElement currentAddressResult;

    public TexBoxPage assertCopyPastText() {
        String permanent = getAddressValue(permanentAddressResult.getText());
        String current = getAddressValue(currentAddressResult.getText());
        Assert.assertTrue(permanent.equals(current));

        return this;
    }

    private static String getAddressValue(String address) {
        String[] parts = address.split(":");
        return parts.length > 1 ? parts[1].trim() : "";}




    }
