package Iframe;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingChildBrowserPopup 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");
//		driver.close();
//		driver.quit();
		
		//To close all the browser windows without using quit();
//		Set<String> awh = driver.getWindowHandles();
//		System.out.println(awh.size());
//		for(String wh:awh)
//		{
//			driver.switchTo().window(wh);
//			driver.close();
//			Thread.sleep(1000);
//		}
		
		//To perform action on a particular browser
//		Set<String> awh = driver.getWindowHandles();
//		for(String wh:awh)
//		{
//			String title = driver.switchTo().window(wh).getTitle();
//			if(title.equals("cognizant"))
//			{
//				driver.manage().window().maximize();
//				Thread.sleep(3000);
//				driver.findElement(By.xpath("//img[@alt='cognizant']")).click();
//				Thread.sleep(3000);
//				driver.quit();
//				break;
//			}
//		}
		
		//To close all the child browsers only
		String parentTitle = driver.getTitle();
		Set<String> awh = driver.getWindowHandles();
		for(String wh:awh)
		{
			String title = driver.switchTo().window(wh).getTitle();
			if(!title.equals(parentTitle))
			{
				driver.close();
				driver.switchTo().window(wh);
			}
		}
	}
}
