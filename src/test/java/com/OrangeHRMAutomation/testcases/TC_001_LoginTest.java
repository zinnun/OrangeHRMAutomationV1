package com.OrangeHRMAutomation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHRMAutomation.pageobjects.loginPage;

public class TC_001_LoginTest extends BaseClass{
	
	@Test
	public void loginOrange() throws InterruptedException
	{
		//TC_LoginTest_001.login(userName, passKey);
		//TC_LoginTest_001 t1 = new TC_LoginTest_001();
		//t1.login(userName, passKey);
		login(userName, passKey);
		
		
		//WebElement dashBoard= driver.findElement(By.xpath("//b[contains(text(),'Dashboard')]"));
		
		
		if(loginPage.dashBoard.isDisplayed()== true) 
		{
			log.info("Dashboard displayed");
			Assert.assertTrue(true);
			log.info("Login Test PASSED!!");
		}
		else 
		{
			Assert.assertTrue(false);
			log.info("Test Failed");
		}
	}
	

	public  void login(String name, String password) throws InterruptedException 
	{
		
		loginPage lp= new loginPage(driver);
		lp.setUsername(name);
		lp.setPassword(password);
		log.info("Username & Password entered");
		Thread.sleep(3000);
		
		lp.clickLoginButton();
		Thread.sleep(3000);
		
		
	}
}
