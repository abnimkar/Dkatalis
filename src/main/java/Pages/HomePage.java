package main.java.Pages;

import main.java.ReusableMethods.ReusableMethods;
import main.java.TestBase.TestBase;
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

    @FindBy(xpath = "(//input[@type='checkbox' and @name='promo'])[2]")
    WebElement Promo_Checkbox_Weekend;

    @FindBy(xpath = "//h1[@class='left' and contains(text(),'Issuing Bank')]")
    WebElement Issuing_Bank_Text;

    @FindBy(xpath = "//iframe[contains(@src,'sandbox')]")
    WebElement iframe2;

    public HomePage() throws Throwable {
        tb = TestBase.getObjectOfTestBase();
        PageFactory.initElements(tb.getDriver(), this);
    }

    public void clickOnBuyNow() {
        BuyNow_Button.click();
        softassert.assertTrue(Checkout_Button.isDisplayed());
    }

    public void clickOnCheckoutButton() {
        Checkout_Button.click();
        rm.waitForFrameToBeLoadAndSwitchToIt(iframe);
        rm.waitForElementToBeVisible(Continue_Button);
        softassert.assertTrue(Continue_Button.isDisplayed());
    }

    public void clickOnContinueButton() {
        rm.waitForElementToBeClickable(Continue_Button);
        rm.clickUsingJavaScriptExecutor(Continue_Button);
    }

    public void clickOnCreditCard() {
        Credit_Card_Option.click();
    }

    public void enterValidCardDetails() {
        CardNumber.sendKeys("4811 1111 1111 1114");
        Expiry_Date.sendKeys("02/22");
        CVV.sendKeys("123");
        softassert.assertTrue(PayNow_Button.isDisplayed());
    }

    public void enterInValidCardCredentials() {
        CardNumber.sendKeys("4811 1111 1111 1113");
        Expiry_Date.sendKeys("02/22");
        CVV.sendKeys("123");
        softassert.assertTrue(PayNow_Button.isDisplayed());
    }

    public void clickOnPayNowButton() {
        rm.scrollDownTillVisibilityOfElement(Promo_Checkbox_Weekend);
        rm.clickUsingJavaScriptExecutor(Promo_Checkbox_Weekend);
        PayNow_Button.click();
        rm.waitForFrameToBeLoadAndSwitchToIt(iframe2);
        rm.waitForElementToBeVisible(Issuing_Bank_Text);
        softassert.assertTrue(Issuing_Bank_Text.isDisplayed());
    }

    public void enterPassWordAndClickOnSubmit() {
        Enter_Password.sendKeys("112233");
        Submit_Button.click();
        tb.getDriver().switchTo().defaultContent();
        rm.waitForElementToBeVisible(Success_Message);
        String message = Success_Message.getText();
        softassert.assertEquals(message, "Thank you for your purchase.");
    }
}
