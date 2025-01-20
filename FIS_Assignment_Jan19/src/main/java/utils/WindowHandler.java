package utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowHandler {
    private WebDriver driver;

    // Constructor
    public WindowHandler(WebDriver driver) {
        this.driver = driver;
    }

    // Method to switch to a new window
    public void switchToNewWindow() {
        String currentWindow = driver.getWindowHandle(); // Get current window handle
        Set<String> windowHandles = driver.getWindowHandles(); // Get all open window handles

        for (String window : windowHandles) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window); // Switch to the new window
                break;
            }
        }
    }

    // Method to switch back to the parent window
    public void switchToParentWindow(String parentWindow) {
        driver.switchTo().window(parentWindow);
    }

    // Method to close the current window
    public void closeCurrentWindowAndSwitchToParent(String parentWindow) {
        driver.close(); // Close current window
        driver.switchTo().window(parentWindow); // Switch back to parent
    }
}
