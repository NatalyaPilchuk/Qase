package pages;

import constants.Credentials;
import constants.Urls;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class LoginPage extends BasePage{
    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class.getName());
    private By email=By.name("email");
    private By password=By.name("password");
    private By checkRemember=By.cssSelector("remember");
    private By loginButton=By.cssSelector("[type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @Step("Open Qase Login page, input email and password")
    public void inputLoginFields(){
        LOGGER.info("Attempt to open login page of Qase");
        driver.get(Urls.QASE_LOGIN);
        LOGGER.info(String.format("Attempt to send email:%s",email));
        driver.findElement(email).sendKeys(Credentials.EMAIL);
        LOGGER.info(String.format("Attempt to send password:%s",password));
        driver.findElement(password).sendKeys(Credentials.PASSWORD);
       // driver.findElement(checkRemember).click();
        LOGGER.info("Follow main page");
        driver.findElement(loginButton).click();
    }
}
