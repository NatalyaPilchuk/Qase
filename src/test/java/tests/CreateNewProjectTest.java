package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.NewProjectPage;

public class CreateNewProjectTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(CreateNewProjectTest.class.getName());
    @Test
    public void createNrwProject(){
        LoginPage loginPage=new LoginPage(driver);
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LOGGER.info(String.format("Open %s page", LoginPage.class.getName()));
        loginPage.inputLoginFields();
        LOGGER.info("Input email and password");
        MainPage mainPage=new MainPage(driver);
        mainPage.clickCreateProjectButton();
        mainPage.FillAllFieldsToCreateProject();
        NewProjectPage newProjectPage=new NewProjectPage(driver);
        Assert.assertEquals(mainPage.getNameOfProject(),newProjectPage.getNameOfProject());
    }
}
