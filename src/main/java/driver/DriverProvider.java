package driver;

import org.openqa.selenium.WebDriver;

public class DriverProvider {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverProvider.driver = driver;
    }

}
