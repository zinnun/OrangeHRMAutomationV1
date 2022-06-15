package com.OrangeHRMAutomation.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHRMAutomation.pageobjects.addEmployeePage;

public class TC_003_addEmployee extends BaseClass{


	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		TC_001_LoginTest tc1 = new TC_001_LoginTest();
		tc1.login(userName, passKey);
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS) ;
		log.info("login successful");

		WebDriverWait wait = new WebDriverWait(driver, 1);
		addEmployeePage emp1 = new addEmployeePage(driver);

		//declaring actions class to move over the webelement
		Actions action = new Actions(driver);

		wait.until(ExpectedConditions.visibilityOf(addEmployeePage.PIM));
		action.moveToElement(addEmployeePage.PIM).build().perform();
		action.moveToElement(addEmployeePage.addEmployee).click().build().perform();
		log.info("add employee page opened");

		//emp1.mouseOverAddEmployee();
		emp1.enterFirstName("Tom");
		//emp1.enterMiddletName("");
		emp1.enterLastName("Cat");
		emp1.enterEmployeeID(2059);
		emp1.clickSaveButton();


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
