package com.OrangeHRMAutomation.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.OrangeHRMAutomation.pageobjects.loginPage;
import com.OrangeHRMAutomation.utilities.AllureReporting;

@Listeners({AllureReporting.class})
public class TC_001_LoginTest extends BaseClass{
	
	public void login(String username, String password) 
	{
		
		loginPage lp= new loginPage(driver);
		//driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		
		lp.setUsername(username);
		lp.setPassword(password);
		log.info("Username & Password entered");
		
		lp.clickLoginButton();
		log.info("logged in");
		
	}
	
	@Test
	public void loginOrange() throws InterruptedException, IOException
	{	
	
		
		login(userName, passKey);
	
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);

	
		if(driver.getPageSource().contains("Dashboard")==true) 
		{
			Assert.assertTrue(true);
			log.info("Login Test PASSED");
		
		}
		else
		{
			takeScreenshot(driver, "loginOrange");
			log.info("Test FAILED!!");
			Assert.assertTrue(false);	
		}

	}
	


}
