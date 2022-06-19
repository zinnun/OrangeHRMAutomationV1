package com.OrangeHRMAutomation.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.OrangeHRMAutomation.pageobjects.addEmployeePage;
import com.OrangeHRMAutomation.utilities.AllureReporting;

@Listeners({AllureReporting.class})
public class TC_003_addEmployee extends BaseClass{


	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		TC_001_LoginTest tc1 = new TC_001_LoginTest();
		tc1.login(userName, passKey);
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS) ;
		log.info("login successful");

		WebDriverWait wait = new WebDriverWait(driver, 1);
		addEmployeePage empl = new addEmployeePage(driver);

		//declaring actions class to move over the webelement
		Actions action = new Actions(driver);

		wait.until(ExpectedConditions.visibilityOf(empl.getPIM()));
		action.moveToElement(empl.getPIM()).build().perform();
		action.moveToElement(empl.getAddEmployee()).click().build().perform();
		log.info("add employee page opened");

		//emp1.mouseOverAddEmployee();
		empl.enterFirstName("Tom");
		//emp1.enterMiddletName("");
		empl.enterLastName("Cat");
		empl.enterEmployeeID(2059);
		empl.clickSaveButton();


		boolean confirm = driver.getPageSource().contains("Personal Details");

		if(confirm)
		{
			Assert.assertTrue(true);
			log.info("adding successful");
			log.info("test passed");
		}
		else
		{
			takeScreenshot(driver, "addNewCustomer");
			driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS) ;
			Assert.assertTrue(false);
			log.info("test failed");
		}

	}
	/*

	public String  randomString(){					//create random String values

		String generatedString= RandomStringUtils.randomAlphabetic(8);

		return generatedString;

	}

	public String randomnumeric()
	{
		String generatednumeric2 = RandomStringUtils.randomNumeric(8);
		return generatednumeric2;


	}
	*/


}
