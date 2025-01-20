package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.WebDriverUtils.waitForElementClickable;
import static utils.WebDriverUtils.waitForElementVisible;

public class ItemPage {
    private WebDriver driver;

    // Locators
    private By addToCartButton = By.xpath("//a[@id='atcBtn_btn_1']");
    private By cartIcon = By.xpath("(//span[@class='gh-cart__icon']//span[@role='img'])[1]");

    // Constructor
    public ItemPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void addToCart() {
        waitForElementClickable(driver, addToCartButton);
        driver.findElement(addToCartButton).click();
    }

    // Verify the cart count
    public boolean verifyCartCount(int expectedCount) {
        try {
            String cartCountText = driver.findElement(cartIcon).getText();
            int actualCount = Integer.parseInt(cartCountText.trim());
            return actualCount == expectedCount;
        } catch (Exception e) {
            System.err.println("Error verifying cart count: " + e.getMessage());
            return false;
        }
    }

    public String getCartItemCount() {
        waitForElementVisible(driver, cartIcon);
        return driver.findElement(cartIcon).getText();
    }
}
