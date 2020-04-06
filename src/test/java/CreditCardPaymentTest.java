package test.java;

import main.java.Pages.HomePage;
import main.java.TestBase.TestBase;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TestCase {

    TestBase tb;
    HomePage hp = new HomePage();

    public TestCase(){
        tb = TestBase.getObjectOfTestBase();
    }

    @Test(priority = 1)
    public void CreditCardPaymentSuccessfulTest() {
            hp.clickOnBuyNow();
            hp.clickOnCheckoutButton();
            hp.clickOnContinueButton();
            hp.clickOnCreditCard();
            hp.enterValidCardDetails();
            hp.clickOnPayNowButton();
            hp.enterPassWordAndClickOnSubmit();
    }

    @Test(priority = 2)
    public void CreditCardPaymentUnSuccessfulTest() {
            hp.clickOnBuyNow();
            hp.clickOnCheckoutButton();
            hp.clickOnContinueButton();
            hp.clickOnCreditCard();
            hp.enterInValidCardCredentials();
            hp.clickOnPayNowButton();
            hp.enterPassWordAndClickOnSubmit();
    }

    @AfterTest
    public void tearDown(){
        tb.getDriver().quit();
    }
}

