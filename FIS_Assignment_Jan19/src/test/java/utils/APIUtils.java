package utils;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class APIUtils {
    // Send a GET request

    public static Response sendGetRequest(String endpoint) {
        return given()
                .relaxedHTTPSValidation() // Handle HTTPS issues
                .when()
                .get(endpoint);
    }

    // Verify if the response contains a specific key and value
    public static boolean verifyResponseContains(Response response, String key, String expectedValue) {
        String actualValue = response.jsonPath().getString(key);
        return actualValue != null && actualValue.equals(expectedValue);
    }
}
