package com.OrangeHRMAutomation.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHRMAutomation.pageobjects.loginPage;

public class TC_LoginTest_001 extends BaseClass{

	@Test
	public void login() throws InterruptedException 
	{
		
		
		
		loginPage lp= new loginPage(driver);
		lp.setUsername(userName);
		lp.setPassword(passKey);
		log.info("Username & Password entered");
		Thread.sleep(3000);
		
		lp.clickLoginButton();
		Thread.sleep(3000);
		
		
		//boolean confirm=driver.getPageSource().contains("actiTIME - Enter Time-Track");
		
		/*
		if (confirm == true) {
			Assert.assertTrue(true);
			log.info("test PASSED!");
			
		}else {
			
			Assert.assertTrue(false);
			log.info("test Failed");
		} */
		
		String title= driver.getTitle();
		System.out.println(title);
		
		if(title.equals("OrangeHRM"))
		{
			Assert.assertTrue(true);
			log.info("Login Test PASSED!!");
		}
		else {
			Assert.assertTrue(false);
			log.info("Test Failed");
		} 
		
		
	}
}
