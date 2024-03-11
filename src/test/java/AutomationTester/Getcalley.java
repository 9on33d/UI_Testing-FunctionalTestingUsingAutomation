package AutomationTester;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class Getcalley {
    static WebDriver driver;

    public static void main(String[] args) {
        launchAndCaptureScreenshots("Chrome");
        launchAndCaptureScreenshots("Firefox");

        // Safari is not supported directly by Selenium
    }

    public static void launchAndCaptureScreenshots(String browser) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.get("https://www.getcalley.com/");

        Dimension[] resolutionsForDesktop = {
                new Dimension(1920, 1080),
                new Dimension(1366, 768),
                new Dimension(1536, 864)
                // Add more resolutions as needed
        };
        Dimension[] resolutionsForMobile = {
                new Dimension(360, 640),
                new Dimension(414, 896),
                new Dimension(375, 667)
                // Add more resolutions as needed
        };

        // Capture screenshots at different resolutions for both desktop and mobile
        for (Dimension resolution : resolutionsForDesktop) {
            captureScreenshot(browser, "Desktop", resolution);
        }

        for (Dimension resolution : resolutionsForMobile) {
            captureScreenshot(browser, "Mobile", resolution);
        }

        // Close the browser
        driver.quit();
    }

    public static void captureScreenshot(String browser, String deviceType, Dimension resolution) {
        Date currentdate = new Date();
        String dateFile = currentdate.toString().replace(" ", "-").replace(":", "");

        // Set the browser window size to the desired resolution
        driver.manage().window().setSize(resolution);

        // Adjust the window inner dimensions using JavaScript
        if (driver instanceof JavascriptExecutor) {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            String setWindowSizeScript = String.format("window.outerWidth = %d; window.outerHeight = %d;", resolution.getWidth(), resolution.getHeight());
            jsExecutor.executeScript(setWindowSizeScript);
        }

        // Convert the resolution to a string for naming the screenshot file
        String resolutionString = resolution.getWidth() + "x" + resolution.getHeight();

        // Capture the screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Define the file name for the screenshot
        String fileName = "Getcalley_" + browser + "_" + deviceType + "_" + resolutionString + "_" + dateFile + ".png";

        // Define the directory where screenshots will be saved
        String directory = "C:\\Users\\Bikram\\eclipse-workspace\\Automation\\src\\test\\java\\AutomationTester\\DealsDray\\" + browser + " " + deviceType + "\\";

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
