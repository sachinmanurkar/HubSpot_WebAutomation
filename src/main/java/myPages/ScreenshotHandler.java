package myPages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotHandler {

    public WebDriver driver;

    public String getScreenshot(String testMethodName) {

        String path;
        try {
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            path = "/Users/sachinm/Developments/DemoFramework/screenshot/" + testMethodName + "_" + ".jpg";
            FileUtils.copyFile(source, new File(path));
        } catch (IOException e) {
            path = "Failed to capture screenshot: " + e.getMessage();
        }
        return path;
    }

    public String getSnapShot(WebDriver driver) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        String path;
        try {
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            path = System.getProperty("user.dir") + "/screenshot/" + this.getClass().getName() + dtf.format(now) + ".jpg";
            FileUtils.copyFile(source, new File(path));
        } catch (IOException e) {
            path = "Failed to capture screenshot: " + e.getMessage();
        }
        return path;
    }
}
