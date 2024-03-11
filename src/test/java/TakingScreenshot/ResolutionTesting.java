package TakingScreenshot;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class ResolutionTesting {
    public static void main(String[] args) {
        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Define a list of resolutions you want to test
        Dimension[] desktopResolutions = {
            new Dimension(1920, 1080),
            new Dimension(1366, 768),
            new Dimension(1536, 864)
            // Add more resolutions as needed
        };
        Dimension[] mobileResolutions = {
                new Dimension(360, 640),
                new Dimension(414, 896),
                new Dimension(375, 667)
                // Add more resolutions as needed
            };

        // Iterate through each resolution
        for (Dimension resolution : desktopResolutions) {
            // Set the browser window size to the current resolution
            driver.manage().window().setSize(resolution);

            // Navigate to your web page
            driver.get("https://www.getcalley.com/");

            // Capture screenshot at the current resolution
            captureScreenshotForDesktop(driver, resolution);

            // Add a wait to observe the changes visually (optional)
            try {
                Thread.sleep(2000); // Wait for 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (Dimension resolution : mobileResolutions) {
            // Set the browser window size to the current resolution
            driver.manage().window().setSize(resolution);

            // Navigate to your web page
            driver.get("https://www.getcalley.com/");

            // Capture screenshot at the current resolution
            captureScreenshotForMobile(driver, resolution);

            // Add a wait to observe the changes visually (optional)
            try {
                Thread.sleep(2000); // Wait for 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Close the browser
        driver.quit();
    }



	public static void captureScreenshotForDesktop(WebDriver driver, Dimension resolution) {
        // Convert Dimension object to a string representation
        String resolutionString = resolution.getWidth() + "x" + resolution.getHeight();

        // Capture screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Define the file name for the screenshot
        String fileName = "Desktop_" + resolutionString + ".png";

        // Define the directory where screenshots will be saved
        String directory = "D:\\Automation Tester\\Screenshots\\Desktop\\";

        // Create the full file path
        String filePath = directory + fileName;

        // Save the screenshot to the specified location
        try {
            FileUtils.copyFile(screenshot, new File(filePath));
            System.out.println("Screenshot captured at resolution: " + resolutionString);
            System.out.println("Screenshot saved to: " + filePath);
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
	public static void captureScreenshotForMobile(WebDriver driver, Dimension resolution) {
        // Convert Dimension object to a string representation
        String resolutionString = resolution.getWidth() + "x" + resolution.getHeight();

        // Capture screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Define the file name for the screenshot
        String fileName = "mobile_" + resolutionString + ".png";

        // Define the directory where screenshots will be saved
        String directory = "D:\\Automation Tester\\Screenshots\\Mobile\\";

        // Create the full file path
        String filePath = directory + fileName;

        // Save the screenshot to the specified location
        try {
            FileUtils.copyFile(screenshot, new File(filePath));
            System.out.println("Screenshot captured at resolution: " + resolutionString);
            System.out.println("Screenshot saved to: " + filePath);
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }

}

