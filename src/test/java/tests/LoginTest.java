package tests;

import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

public class LoginTest extends BaseTest{
    private static final Logger LOGGER = LogManager.getLogger(LoginTest.class.getName());
    @Test(description = "user log in Qase")
    @Description("User log in Qase")
    public void loginToQase(){
        LoginPage loginPage=new LoginPage(driver);
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LOGGER.info(String.format("Open %s page", LoginPage.class.getName()));
        loginPage.inputLoginFields();
        LOGGER.info("Input email and password");
        MainPage mainPage=new MainPage(driver);
        LOGGER.info("Check if  the sign logout is displayed");
        Assert.assertTrue(mainPage.isSignDisplayed(), "we didn't login");
    }
}
