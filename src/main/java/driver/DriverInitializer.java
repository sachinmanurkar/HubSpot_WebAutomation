package driver;

import browserFactory.ChromeBrowser;
import browserFactory.ChromeMobileEmulator;
import browserFactory.FirefoxBrowser;
import constants.Browsers;
import listners.EventHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class DriverInitializer {

    private String browser;
    private EventFiringWebDriver eventDriver;

    public DriverInitializer(String browser) {
        this.browser = browser;
    }

    public WebDriver init() {

        WebDriver webDriver = null;

        switch (browser) {

            case Browsers.CHROME:
                webDriver = new ChromeBrowser().getDriver();
                break;

            case Browsers.FIREFOX:
                webDriver = new FirefoxBrowser().getDriver();
                break;

            case Browsers.MOBILE_DEVICE:
                webDriver = new ChromeMobileEmulator().getDriver();

        }

        eventDriver = new EventFiringWebDriver(webDriver);
        EventHandler handler = new EventHandler();
        eventDriver.register(handler);

        DriverProvider.setDriver(eventDriver);
        return eventDriver;

    }

}
