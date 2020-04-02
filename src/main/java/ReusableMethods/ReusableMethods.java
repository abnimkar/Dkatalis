package main.java.ReusableMethods;

import main.java.TestBase.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableMethods {

    TestBase tb;

    public ReusableMethods() throws Throwable {
        tb = TestBase.getObjectOfTestBase();
    }

    public void waitForFrameToBeLoadAndSwitchToIt(WebElement xpath) {
        WebDriverWait wait = new WebDriverWait(tb.getDriver(), 30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(xpath));
    }

    public void waitForElementToBeVisible(WebElement locator) {
        WebDriverWait wait1 = new WebDriverWait(tb.getDriver(), 50);
        wait1.until(ExpectedConditions.visibilityOf(locator));
    }

    public void waitForElementToBeClickable(WebElement locator) {
        WebDriverWait wait2 = new WebDriverWait(tb.getDriver(), 30);
        wait2.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void scrollDownTillVisibilityOfElement(WebElement locator){
        JavascriptExecutor js1 = (JavascriptExecutor)tb.getDriver();
        js1.executeScript("arguments[0].scrollIntoView();",locator);
    }

    public void clickUsingJavaScriptExecutor(WebElement locator){
        JavascriptExecutor js2 = (JavascriptExecutor)tb.getDriver();
        js2.executeScript("arguments[0].click();",locator);
    }
}
