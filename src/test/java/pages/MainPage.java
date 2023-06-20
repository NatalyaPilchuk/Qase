package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.FakeMessageGenerator;

public class MainPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(MainPage.class.getName());
    private By sign = By.cssSelector("[class='k8uCSO cYWQeK']");
    private By createProjectButton = By.id("createButton");
    private By nameOfProject = By.xpath("//div[contains(@class,'PneUlE Pda0_5')]//input[@id='project-name']");
    private By codeOfProject = By.xpath("//div[contains(@class,'PneUlE Pda0_5')]//input[@id='project-code']");
    private By textInput = By.xpath("//div[contains(@class,'PneUlE Pda0_5')]//textarea[@id='description-area']");
    private By createButton=By.xpath("//div[contains(@class,'CCVJRT')]//button[@type='submit']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check is sign of Qase is displayed")
    public boolean isSignDisplayed() {
        LOGGER.info(String.format("Attempt to find sign:%s", sign));
        return driver.findElement(sign).isDisplayed();
    }

    @Step("Create new button click")
    public void clickCreateProjectButton() {
        LOGGER.info(String.format("Click new project button", createProjectButton));
        driver.findElement(createProjectButton).click();
    }
    public void FillAllFieldsToCreateProject(){
        driver.findElement(nameOfProject).sendKeys(FakeMessageGenerator.generateFirstName());
       // driver.findElement(codeOfProject).sendKeys(FakeMessageGenerator.generateZipCode());
        driver.findElement(textInput).sendKeys(FakeMessageGenerator.generateDescription());
        driver.findElement(createButton).click();
    }

   public String getNameOfProject(){
        return driver.findElement(nameOfProject).getText();
   }
}
