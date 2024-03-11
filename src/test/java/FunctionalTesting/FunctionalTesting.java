package FunctionalTesting;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FunctionalTesting 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.dealsdray.com/");
		
		Thread.sleep(1000);
	    WebElement usernameInput = driver.findElement(By.name("username"));
	    WebElement passwordInput = driver.findElement(By.name("password"));

	    Thread.sleep(1000);
	        // Enter the username and password
	    usernameInput.sendKeys("prexo.mis@dealsdray.com");
	    Thread.sleep(1000);
	    passwordInput.sendKeys("prexo.mis@dealsdray.com");

	    Thread.sleep(1000);
	        // Locate and click the login button
	    WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
	    loginButton.click();
	    Thread.sleep(3000);
	    
	    WebElement order = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[1]/div[2]/button/div[2]/span"));
	    order.click();
	    
	    Thread.sleep(3000);
	    WebElement orders = driver.findElement(By.xpath("//span[text()='Orders']"));
	    orders.click();
	    
	    Thread.sleep(5000);
	    WebElement addBulkOrder = driver.findElement(By.xpath("//button[text()='Add Bulk Orders']"));
	    addBulkOrder.click();
	    
	    Thread.sleep(5000);
	    WebElement inputFile = driver.findElement(By.xpath("//input[@type='file']"));
	    String filePath = "D:\\Automation Tester\\demo-data.xlsx";
	    inputFile.sendKeys(filePath);
	    
	    Thread.sleep(3000);
	    WebElement submitButton = driver.findElement(By.xpath("//button[text()='Import']"));
        submitButton.click();
        
        Thread.sleep(3000);
        WebElement validation = driver.findElement(By.xpath("//button[text()='Validate Data']"));
        validation.click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        
        WebElement Screenshot = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]"));
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Define the file name for the screenshot
        String fileName = "Data.png";

        // Define the directory where screenshots will be saved
        String directory = "C:\\Users\\Bikram\\eclipse-workspace\\Automation\\src\\test\\java\\AutomationTester\\DealsDray\\";

        // Create the full file path
        String filePath1 = directory + fileName;
        try {
            FileUtils.copyFile(screenshot, new File(filePath1));
            System.out.println("Screenshot saved to: " + filePath1);
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
	}
}
