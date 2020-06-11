package myTests;

import driver.DriverInitializer;
import driver.DriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import myPages.BasePage;
import myPages.Page;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import properties.PropertiesReader;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;
    public Page page;
    protected PropertiesReader propertiesReader;


    @BeforeMethod
    public void setup(ITestContext iTestContext) {
        driver = new DriverInitializer("chrome").init();
        iTestContext.setAttribute("WebDriver", driver);
        propertiesReader = new PropertiesReader();
        page = new BasePage(driver);
        navigateToUrl();
    }

    public void navigateToUrl() {
        driver.get(propertiesReader.getUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
