package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WindowHandler;

import java.time.Duration;

import static utils.WebDriverUtils.waitForElementClickable;

public class SearchResultPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private WindowHandler windowHandler;

    // Locators
    private By firstItemLink = By.xpath("//ul[contains(@class,'srp-results')]//li[contains(@class,'s-item')][1]//a[@class='s-item__link']");

    // Constructor
    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.windowHandler = new WindowHandler(driver);
    }

    // Actions
    public void clickFirstItem() {
        waitForElementClickable(driver, firstItemLink);
        driver.findElement(firstItemLink).click();
        windowHandler.switchToNewWindow();
    }
}
