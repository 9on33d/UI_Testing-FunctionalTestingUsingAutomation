package Popups;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingPopups 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("E:\\Interview Question\\Pop ups\\okPopUp.html");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Try It']")).click();
		
		Alert al = driver.switchTo().alert();
		Thread.sleep(2000);
		System.out.println(al.getText());
		Thread.sleep(2000);
		al.accept();
		driver.get("E:\\Interview Question\\Pop ups\\confirmPopUp.html");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='I Love You']")).click();
		Thread.sleep(2000);
		Alert all = driver.switchTo().alert();
		Thread.sleep(1000);
		System.out.println(al.getText());
		Thread.sleep(1000);
		
		//to click on ok button
		all.accept();
		//to click on cancel button
//		all.dismiss();
//		//Handling hidden division popup
		driver.close();
	}
}
