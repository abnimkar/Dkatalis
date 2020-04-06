package main.java.Pages;

import main.java.ReusableMethods.ReusableMethods;
import main.java.TestBase.TestBase;
import main.java.TestDataUtility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class HomePage {

    TestBase tb;
    ReusableMethods rm = new ReusableMethods();
    SoftAssert softassert = new SoftAssert();

    @FindBy(xpath = "//a[@class='btn buy']")
    WebElement BuyNow_Button;

    @FindBy(xpath = "//div[@class='cart-checkout']")
    WebElement Checkout_Button;

    @FindBy(xpath = "//div[@class='text-button-main']/span")
    WebElement Continue_Button;

    @FindBy(xpath = "//iframe[@id='snap-midtrans']")
    WebElement iframe;

    @FindBy(xpath = "//div[@class='list-title text-actionable-bold' and text()='Credit Card']")
    WebElement Credit_Card_Option;

    @FindBy(name = "cardnumber")
    WebElement CardNumber;

    @FindBy(xpath = "//input[@placeholder='MM / YY']")
    WebElement Expiry_Date;

    @FindBy(xpath = "//input[@inputmode='numeric']")
    WebElement CVV;

    @FindBy(xpath = "//a[@class='button-main-content']")
    WebElement PayNow_Button;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement Submit_Button;

    @FindBy(xpath = "(//div[@class='trans-status trans-success']/span)[1]")
    WebElement Success_Message;

    @FindBy(id = "PaRes")
    WebElement Enter_Password;

    @FindBy(xpath = "//input[@type='checkbox' and @name='promo']")
    WebElement Promo_Checkbox_Weekend;

    @FindBy(xpath = "//h1[@class='left' and contains(text(),'Issuing Bank')]")
    WebElement Issuing_Bank_Text;

    @FindBy(xpath = "//iframe[contains(@src,'sandbox')]")
    WebElement iframe2;

    public HomePage() {
        tb = TestBase.getObjectOfTestBase();
        PageFactory.initElements(tb.getDriver(), this);
    }

    public void clickOnBuyNow() {
        try {
            BuyNow_Button.click();
            softassert.assertTrue(Checkout_Button.isDisplayed());
        } catch (Exception e) {
            e.getMessage();
            throw e;
        }


    }

    public void clickOnCheckoutButton() {
        try {
            Checkout_Button.click();
            rm.waitForFrameToBeLoadAndSwitchToIt(iframe);
            rm.waitForElementToBeVisible(Continue_Button);
            softassert.assertTrue(Continue_Button.isDisplayed());
        } catch (Exception e) {
            e.getMessage();
            throw e;
        }

    }

    public void clickOnContinueButton() {
        try {
            rm.waitForElementToBeClickable(Continue_Button);
            rm.clickUsingJavaScriptExecutor(Continue_Button);
        } catch (Exception e) {
            e.getMessage();
            throw e;
        }

    }

    public void clickOnCreditCard() {
        try {
            Credit_Card_Option.click();
        } catch (Exception e) {
            e.getMessage();
            throw e;
        }
    }

    public void enterValidCardDetails() {
        try {
            CardNumber.sendKeys(Utility.getPropertyAndLoadFile("ValidCardNumber"));
            Expiry_Date.sendKeys(Utility.getPropertyAndLoadFile("ExpiryDate"));
            CVV.sendKeys(Utility.getPropertyAndLoadFile("CVVNumber"));
            softassert.assertTrue(PayNow_Button.isDisplayed());

        } catch (Exception e) {
            e.getMessage();
            throw e;
        }

    }

    public void enterInValidCardCredentials() {
        try {
            CardNumber.sendKeys(Utility.getPropertyAndLoadFile("InValidCardNumber"));
            Expiry_Date.sendKeys(Utility.getPropertyAndLoadFile("ExpiryDate"));
            CVV.sendKeys(Utility.getPropertyAndLoadFile("CVVNumber"));
            softassert.assertTrue(PayNow_Button.isDisplayed());
        } catch (Exception e) {
            e.getMessage();
            throw e;
        }

    }

    public void clickOnPayNowButton() {
        try {
            rm.scrollDownTillVisibilityOfElement(Promo_Checkbox_Weekend);
            rm.clickUsingJavaScriptExecutor(Promo_Checkbox_Weekend);
            PayNow_Button.click();
            rm.waitForFrameToBeLoadAndSwitchToIt(iframe2);
            rm.waitForElementToBeVisible(Issuing_Bank_Text);
            softassert.assertTrue(Issuing_Bank_Text.isDisplayed());
        } catch (Exception e) {
            e.getMessage();
            throw e;
        }


    }


    public void enterPassWordAndClickOnSubmit() {
        try {
            Enter_Password.sendKeys(Utility.getPropertyAndLoadFile("OTPNumber"));
            Submit_Button.click();
            tb.getDriver().switchTo().defaultContent();
            rm.waitForElementToBeVisible(Success_Message);
            String message = Success_Message.getText();
            softassert.assertEquals(message, "Thank you for your purchase.");
        } catch (Exception e) {
            e.getMessage();
            throw e;
        }

    }
}
