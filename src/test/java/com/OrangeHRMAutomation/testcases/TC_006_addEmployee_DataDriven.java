package com.OrangeHRMAutomation.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OrangeHRMAutomation.pageobjects.addEmployeePage;
import com.OrangeHRMAutomation.utilities.XLUtils;

public class TC_006_addEmployee_DataDriven extends BaseClass{


	@Test(dataProvider = "LoginData")
	public void addNewCustomerDD(String first_name, String last_name) throws InterruptedException, IOException
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
		emp1.enterFirstName(first_name);
		//emp1.enterMiddletName("");
		emp1.enterLastName(last_name);

		emp1.clickSaveButton();


		boolean confirm = driver.getPageSource().contains("Personal Details");


		if(confirm)
		{
			Assert.assertTrue(true);
			log.info("adding " + first_name+ " "+last_name+" successful");
			log.info("Test Passed");

			wait.until(ExpectedConditions.visibilityOf(addEmployeePage.account));
			addEmployeePage.account.click();
			driver.manage().timeouts().implicitlyWait(1500,TimeUnit.MILLISECONDS) ;
			action.moveToElement(addEmployeePage.logout).click().build().perform();

		}
		else
		{
			takeScreenshot(driver, "addNewCustomerDD");
			Assert.assertTrue(false);
			log.info("Test Failed!!");

		}

	}


	// data provider method for the method "loginDDT"
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{

		String pathOfSheet=System.getProperty("user.dir")+"/src/test/java/com/OrangeHRMAutomation/testData/Employees_Data.xlsx";
		int rownum= XLUtils.getRowCount(pathOfSheet, "Sheet1");
		int colNum= XLUtils.getCellcount(pathOfSheet, "Sheet1", 1);

		//declaring 2D array to store cell values, the number of row and column will determine the size of this array
		String[][] logindata = new String [rownum][colNum];


		//row count starts from 1 as the first row is used for title
		for(int i=1; i<=rownum; i++) {

				// column count starts from 0
				for (int j = 0; j < colNum; j++)
				{
					//storing excel cell values in the array
					logindata[i-1][j]= XLUtils.getCellData(pathOfSheet, "Sheet1", i, j);

				}
		}
		return logindata;

	}



}
