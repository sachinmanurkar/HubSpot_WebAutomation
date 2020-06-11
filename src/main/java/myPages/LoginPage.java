package myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private By emailId = By.id("username");
    private By password = By.id("password");
    private By loginButton = By.id("loginBtn");
    private By header = By.xpath("//i18n-string[contains(text(),\"Don't have an account\")]");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getEmailId() {
        return getElement(emailId);
    }

    public WebElement getPassword() {
        return getElement(password);
    }

    public WebElement getLoginButton() {
        return getElement(loginButton);
    }

    public String getLoginPageTitle() {
        return getPageTitle();
    }

    public String getLoginPageHeader() {
        return getPageHeader(header);
    }

    public HomePage login(String username, String password) throws InterruptedException {
        getEmailId().sendKeys(username);
        getPassword().sendKeys(password);
        getLoginButton().click();
        Thread.sleep(6000);


        return getInstance(HomePage.class);

    }

}
