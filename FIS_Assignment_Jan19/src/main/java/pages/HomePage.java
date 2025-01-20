package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.WebDriverUtils.waitForElementClickable;
import static utils.WebDriverUtils.waitForElementVisible;

public class HomePage {

    private WebDriver driver;

    // Locators
    private By searchBox = By.id("gh-ac");
    private By searchButton = By.id("gh-btn");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void searchForItem(String item) {
        //driver.findElement(searchBox).sendKeys(item);
        waitForElementVisible(driver, searchBox);
        driver.findElement(searchBox).sendKeys(item + Keys.ENTER);
        //driver.findElement(searchButton).click();
    }
}
