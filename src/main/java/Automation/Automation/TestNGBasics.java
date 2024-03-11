package Automation.Automation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics 
{
//	pre-condition annotations -----starting with @Before
	@BeforeSuite
	public void setUp()
	{
		System.out.println("setup system property for chrome");
	}
	@BeforeTest
	public void launchBrowser()
	{
		System.out.println("launch chrome Browser");
	}
	@BeforeClass
	public void login()
	{
		System.out.println("login to app");
	}

	@BeforeMethod
	public void enterURL()
	{
		System.out.println("enter URL");
	}
//	test cases------starting with @Test
	@Test
	public void googleTitleTest()
	{
		System.out.println("Google Title Test");
	}
	@Test
	public void searchTest()
	{
		System.out.println("search Test");
	}
	@Test
	public void googleLogoTest()
	{
		System.out.println("Google logo Test");
	}
//	Post-conditions---------starting with @After
	@AfterMethod
	public void logOut()
	{
		System.out.println("logout from app");
	}
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("close Browser");
	}
	@AfterTest
	public void deleteAllCookies()
	{
		System.out.println("deleteAllCookies");
	}
	
	@AfterSuite
	public void generateTestReport()
	{
		System.out.println("generate test report");
	}
}
