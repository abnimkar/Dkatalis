package main.java.TestBase;

import main.java.TestDataUtility.Utility;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase {

    private WebDriver driver;
    private static TestBase tb = null;

    private TestBase() {
        String BrowserName = Utility.getPropertyAndLoadFile("BrowserName");

        DesiredCapabilities capability = null;

        if (BrowserName.equalsIgnoreCase("firefox")) {
            capability = DesiredCapabilities.firefox();
            capability.setBrowserName("firefox");
            capability.setPlatform(Platform.ANY);
            capability.setVersion(capability.getVersion());
        } else if (BrowserName.equalsIgnoreCase("iexplore")) {
            capability = DesiredCapabilities.internetExplorer();
            capability.setBrowserName("iexplore");
            capability.setPlatform(Platform.ANY);
            capability.setVersion(capability.getVersion());
        } else if (BrowserName.equalsIgnoreCase("chrome")) {
            capability = DesiredCapabilities.chrome();
            capability.setBrowserName("iexplore");
            capability.setPlatform(Platform.ANY);
            capability.setVersion(capability.getVersion());
        } else if (BrowserName.equalsIgnoreCase("safari")) {
            capability = DesiredCapabilities.safari();
            capability.setBrowserName("safari");
            capability.setPlatform(Platform.ANY);
            capability.setVersion(capability.getVersion());
        }

        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
        } catch (MalformedURLException e) {
            e.getMessage();
        }

        assert driver != null;
        driver.get(Utility.getPropertyAndLoadFile("URL"));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    public static TestBase getObjectOfTestBase(){
        if (tb == null) {
            tb = new TestBase();
        }

        return tb;
    }

    public WebDriver getDriver() {
        return driver;
    }

}
