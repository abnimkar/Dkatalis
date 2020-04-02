package main.java.TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    private static Properties prop;
    private static WebDriver driver;
    private static TestBase tb = null;

    private TestBase() throws Throwable {
        prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\Config\\Config.properties");
        prop.load(fis);

        String BrowserName = prop.getProperty("BrowserName");

        if (BrowserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\All_Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (BrowserName.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\All_Drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (BrowserName.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\All_Drivers\\IEDriverSever.exe");
            driver = new InternetExplorerDriver();
        }

        driver.get(prop.getProperty("URL"));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    public static TestBase getObjectOfTestBase() throws Throwable {
        if (tb == null) {
            tb = new TestBase();
        }

        return tb;
    }

    public WebDriver getDriver() {
        return driver;
    }

}
