package myTests;

import listners.TesultsListener;
import myPages.HomePage;
import myPages.LoginPage;
import myPages.UserPrefrences;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.Categories;

@Listeners(TesultsListener.class)
public class HubSpotTests extends BaseTest {


    @Test(priority = 1, groups = {Categories.SMOKE})
    public void verifyLoginPageTitle() {
        page.waitForPageTitle("HubSpot Login");
        String pageTitle = page.getInstance(LoginPage.class).getLoginPageTitle();
        System.out.println(pageTitle);
        Assert.assertEquals(pageTitle, "HubSpot Login");

    }

    @Test(priority = 2, groups = {Categories.SMOKE})
    public void verifyLoginPageHeader() {
        String pageHeader = page.getInstance(LoginPage.class).getLoginPageHeader();
        System.out.println(pageHeader);
        Assert.assertEquals(pageHeader, "Don't have an account?");
    }

    @Test(priority = 3, groups = {Categories.SMOKE})
    public void login() throws InterruptedException {
        HomePage homepage = page.getInstance(LoginPage.class).login(propertiesReader.getUsername(), propertiesReader.getPassword());
        String homePageHeader = homepage.getHomePageHeader();
        System.out.println(homePageHeader);
        Assert.assertEquals(homePageHeader, "Getting started with HubSpot123");
    }

    @Test(priority = 4, groups = {Categories.SMOKE})
    public void verifyAccountHolderName() throws InterruptedException {
        page.getInstance(LoginPage.class).login(propertiesReader.getUsername(), propertiesReader.getPassword());
        UserPrefrences userPreferencesPage = page.getInstance(HomePage.class).clickOnAccountMenu();
        String accountName = userPreferencesPage.getAccountDetails();
        Assert.assertEquals(accountName, "Sachin M");
    }
}

