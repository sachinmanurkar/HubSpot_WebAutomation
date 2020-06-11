package myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserPrefrences extends BasePage {


    By accountName = By.xpath("//span[contains(text(),'Sachin M')]");

    public UserPrefrences(WebDriver driver) {
        super(driver);
    }

    public WebElement getAccountName() {
        return getElement(accountName);
    }


    public String getAccountDetails() {
        wait.until(ExpectedConditions.presenceOfElementLocated(accountName));
        return getAccountName().getText();
    }
}
