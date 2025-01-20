package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.ItemPage;
import pages.SearchResultPage;
import utils.ConfigReader;
import utils.ExtentReportManager;
import utils.WebDriverUtils;

import java.time.Duration;

public class ebayUITest extends BaseTest{
    @BeforeMethod
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void addBookToCartTest() {

        createTest("Search and Add to Cart Test");
        // Start a new test in the Extent Report

        try {
            String appUrl = ConfigReader.getProperty("base.url");
            getTest().info("Navigating to application URL: " + appUrl);
            // Navigate to eBay
            driver.get(appUrl);

            // Page Object Instances
            HomePage homePage = new HomePage(driver);
            SearchResultPage searchResultsPage = new SearchResultPage(driver);
            ItemPage itemPage = new ItemPage(driver);

            // Search for "book"
            homePage.searchForItem("Book");
            getTest().info("Searching for 'book' on the homepage");

            // Click the first item in the search results
            searchResultsPage.clickFirstItem();
            getTest().info("Clicked on the first item.");

            // Add the item to the cart
            itemPage.addToCart();
            getTest().info("Added the item to the cart.");

            // Verify the cart item count is updated
            boolean isCartUpdated = itemPage.verifyCartCount(1);
            getTest().info("Verified cart count is updated.");
            if (isCartUpdated) {
                getTest().pass("Cart updated successfully with 1 item.");
            } else {
                getTest().fail("Cart was not updated as expected.");
            }

        } catch (Exception e) {
            getTest().fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
