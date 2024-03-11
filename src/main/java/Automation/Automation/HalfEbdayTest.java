package Automation.Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HalfEbdayTest 
{
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/login/");
	}
	
	@DataProvider
	public void getTestData()
	{
		
	}
	
	@Test
	public void halfEbdayRegPageTest(String Phone, String Password)
	{
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Phone);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(Password);
		
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
