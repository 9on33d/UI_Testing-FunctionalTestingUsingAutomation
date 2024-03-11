package Automation.Automation;

import org.testng.annotations.Test;

public class TestNgFeatures 
{
	@Test
	public void loginTest()
	{
		System.out.println("login test");
		int i = 9/0;
	}
	@Test(dependsOnMethods = "loginTest")
	public void homePageTest()
	{
		System.out.println("homepage test");
	}
	@Test(dependsOnMethods = "loginTest")
	public void searchPageTest()
	{
		System.out.println("search page test");
	}
	@Test(dependsOnMethods = "loginTest")
	public void regPageTest()
	{
		System.out.println("reg page test");
	}
}
