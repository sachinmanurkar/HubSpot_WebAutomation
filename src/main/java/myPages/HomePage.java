package myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private By header = By.xpath("//i18n-string[contains(text(),'Getting started with HubSpot')]");
    private By accountMenu = By.id("account-menu");

    private By profileAndPreferences = By.xpath("//div[contains(text(),'Profile & Preferences')]");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public By getHeader() {
        return header;
    }

    //Page actions
    public String getHomePageTitle() {
        return getPageTitle();
    }

    public WebElement getAccountMenu() {
        return getElement(accountMenu);
    }

    public WebElement getProfileAndPreferences() {
        return getElement(profileAndPreferences);
    }


    public String getHomePageHeader() {
        return getPageHeader(header);
    }


    public UserPrefrences clickOnAccountMenu() throws InterruptedException {
        Thread.sleep(3000);
        getAccountMenu().click();
        getProfileAndPreferences().click();
        return getInstance(UserPrefrences.class);

    }

}

