package org.example;

import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.RectangleSize;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplitoolsPOC {

    @Test
    public void testGoogleHomePage() {
        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Initialize Applitools Eyes
        Eyes eyes = new Eyes();
        eyes.setApiKey("6ttcRgnGaXEm9EaipEFHWEqZYStcEuRAUL00Vyvvve0110");

        try {
            // Start test session
            eyes.open(driver, "POC App", "Dynamic element locator",
                    new RectangleSize(800, 600));

            // Navigate to site
            driver.get("https://the-internet.herokuapp.com/shifting_content/menu?mode=random&pixel_shift=100");

            // Visual checkpoint
            eyes.checkWindow("Dynamic element locator");

            // End test
            eyes.closeAsync();
        } finally {
            driver.quit();
            eyes.abortIfNotClosed();
        }
    }
}
