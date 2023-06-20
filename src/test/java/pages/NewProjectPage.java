package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewProjectPage extends BasePage{
    private static final Logger LOGGER = LogManager.getLogger(NewProjectPage.class.getName());
    private By nameOfProject=By.cssSelector("[class='LALnEw']");

    public NewProjectPage(WebDriver driver) {
        super(driver);
    }
    @Step("Look at the name of new project")
    public String getNameOfProject(){
        LOGGER.info("");
        return driver.findElement(nameOfProject).getText();
    }
}
