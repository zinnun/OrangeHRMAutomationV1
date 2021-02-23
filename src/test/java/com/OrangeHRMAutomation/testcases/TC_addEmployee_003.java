package com.OrangeHRMAutomation.testcases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHRMAutomation.pageobjects.addEmployeePage;
import com.OrangeHRMAutomation.pageobjects.loginPage;

public class TC_addEmployee_003 extends BaseClass{
	
	
	@Test
	public void addNewCustomer() throws InterruptedException
	{
		loginPage lp1 = new loginPage(driver);
		//loginOrange(userName, passKey);
		lp1.setUsername(userName);
		lp1.setPassword(passKey);
		lp1.clickLoginButton();
		
		Thread.sleep(3000);
		log.info("login successful");
		
		addEmployeePage emp1 = new addEmployeePage(driver);
	
		//declaring actions class to move over the webelement
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 1);
		wait.until(ExpectedConditions.visibilityOf(addEmployeePage.PIM));
		//Thread.sleep(3000);
		act.moveToElement(addEmployeePage.PIM).build().perform();
		act.moveToElement(addEmployeePage.addEmployee).click().build().perform();
		log.info("add employee page opened");
		
		//emp1.mouseOverAddEmployee();
		emp1.enterFirstName("Tom");
		//emp1.enterMiddletName("");
		emp1.enterLastName("Cat");
		emp1.enterEmployeeID(2059);
		emp1.clickSaveButton();
		log.info("adding successful");
		
		boolean confirm = driver.getPageSource().contains("Personal Details");
		
		if(confirm == true)
		{
			Assert.assertTrue(true);
			log.info("test passed");
		}
		else
		{
			Assert.assertTrue(false);
			log.info("test failed");
		}
		
	}
	
	
	public String  randomString(){					//create random String values
		
		String generatedString= RandomStringUtils.randomAlphabetic(8);
		
		return generatedString;
		
	}
	
	public String randomnumeric() 
	{
		String generatednumeric2 = RandomStringUtils.randomNumeric(8);
		return generatednumeric2;
		
		
	}
	
	public static void loginOrange(String uname, String pass) throws InterruptedException
	{
		loginPage lp = new loginPage(driver);
		lp.setUsername(uname);
		lp.setPassword(pass);
		lp.clickLoginButton();
		Thread.sleep(3000);
	}

}
