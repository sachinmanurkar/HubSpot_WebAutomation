package browserFactory;

import constants.Browsers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class ChromeMobileEmulator implements BrowserDriver {

    @Override
    public WebDriver getDriver() {
        setBinaryPath();
        return new ChromeDriver(mobileChromeBrowser());
    }

    public ChromeOptions mobileChromeBrowser() {
        Map<String, String> mobileEmulation = new HashMap<String, String>();
        mobileEmulation.put("deviceName", Browsers.MOBILE_DEVICE);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        return chromeOptions;

    }

    @Override
    public void setBinaryPath() {

        System.setProperty("webdriver.chrome.silentOutput", "true");
        WebDriverManager.chromedriver().setup();
    }

}
