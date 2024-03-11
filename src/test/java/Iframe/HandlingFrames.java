package Iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrames 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("E:\\Interview Question\\Pop ups\\mainpage.html");
		Thread.sleep(2000);
//		driver.switchTo().frame(0);
//		driver.switchTo().frame("frid");
//		driver.switchTo().frame("from");
//		driver.switchTo().frame("frc1");
//		
		WebElement frAddr = driver.findElement(By.id("frid"));
		driver.switchTo().frame(frAddr);
		driver.findElement(By.id("i2")).sendKeys("manager");
		Thread.sleep(2000);
//		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.findElement(By.id("i1")).sendKeys("admin");
	}
}
