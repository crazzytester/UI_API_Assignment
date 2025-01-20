package tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.APIUtils;
import utils.ConfigReader;


public class coinDeskAPITest extends BaseTest{

    @Test
    public void testBitcoinPriceAPI() {

        createTest("Verify BPI Response Test");

        try {
            // Read API endpoint from config.properties
            String apiEndpoint = ConfigReader.getProperty("api.url");
            getTest().info("Sending GET request to API endpoint: " + apiEndpoint);

            // Send GET request
            Response response = APIUtils.sendGetRequest(apiEndpoint);
            getTest().info("Response received: " + response.asPrettyString());

            // Verify response contains USD, GBP, and EUR
            getTest().info("Verifying response contains keys: USD, GBP, EUR");
            Assert.assertTrue(response.jsonPath().get("bpi.USD") != null, "USD not found in response!");
            Assert.assertTrue(response.jsonPath().get("bpi.GBP") != null, "GBP not found in response!");
            Assert.assertTrue(response.jsonPath().get("bpi.EUR") != null, "EUR not found in response!");
            getTest().pass("USD, GBP, and EUR keys found in the response.");

            // Verify GBP description is "British Pound Sterling"
            getTest().info("Verifying GBP description equals 'British Pound Sterling'");
            boolean isGBPDescriptionValid = APIUtils.verifyResponseContains(response, "bpi.GBP.description", "British Pound Sterling");
            Assert.assertTrue(isGBPDescriptionValid, "GBP description does not match!");
            getTest().pass("GBP description verified successfully.");
        }
        catch (Exception e) {
            getTest().fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
