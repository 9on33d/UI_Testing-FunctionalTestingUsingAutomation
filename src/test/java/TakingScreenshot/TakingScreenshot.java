package TakingScreenshot;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class TakingScreenshot {
    public static void main(String[] args){
        // Create a ChromeDriver instance
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.getcalley.com/");
        
        // Define a list of resolutions you want to test
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
        // Capture screenshots at different resolutions
        for (Dimension resolution : resolutionsForDesktop) {
            captureScreenshotForDesktop(driver, resolution);
        }
        for (Dimension resolution : resolutionsForMobile) {
            captureScreenshotForMobile(driver, resolution);
        }
        
        // Close the browser
        driver.quit();
    }

    public static void captureScreenshotForDesktop(WebDriver driver, Dimension resolution) {
        // Set the browser window size to the desired resolution
        driver.manage().window().setSize(resolution);

        captureScreenshot(driver, "Desktop", resolution);
    }

    public static void captureScreenshotForMobile(WebDriver driver, Dimension resolution) {
        // Set the browser window size to the desired resolution
        driver.manage().window().setSize(resolution);

        captureScreenshot(driver, "Mobile", resolution);
    }

    public static void captureScreenshot(WebDriver driver, String deviceType, Dimension resolution) {
        Date currentdate = new Date();
        String dateFile = currentdate.toString().replace(" ", "-").replace(":", "");

        // Convert the resolution to a string for naming the screenshot file
        String resolutionString = resolution.getWidth() + "x" + resolution.getHeight();

        // Capture the screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Define the file name for the screenshot
        String fileName = "screenshot_" + deviceType + "_" + resolutionString + "_" + dateFile + ".png";

        // Define the directory where screenshots will be saved
        String directory = "D:\\Automation Tester\\Screenshots\\" + deviceType + "\\";

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
