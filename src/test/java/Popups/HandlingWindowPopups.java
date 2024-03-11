package Popups;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingWindowPopups 
{
	public static void main(String[] args) throws InterruptedException,AWTException 
	{
		//Handling File Upload Popup
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.monsterindia.com/");
//		driver.findElement(By.xpath("//span[text()='Upload Resume']")).click();
//		Thread.sleep(2000);
//		
//		//Hidden Division Popup will be opened
//		WebElement uploadbtn=driver.findElement(By.id("file-upload"));
//		uploadbtn.sendKeys("E:\\Interview Question\\Bikram_Jena_CV(2).pdf");
		
		//File Download Popup
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/downloads/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//p[text()='Java']/following-sibling::p[@class])"));
		Thread.sleep(2000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
}
