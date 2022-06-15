package com.OrangeHRMAutomation.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHRMAutomation.pageobjects.editEmployeeDetails;
import com.OrangeHRMAutomation.utilities.DropDownSelect;

public class TC_004_EditEmployeedetails extends BaseClass{

	@Test
	public void editInfo() throws InterruptedException, IOException {

		WebDriverWait wait = new WebDriverWait(driver, 3);
		TC_001_LoginTest t1 = new TC_001_LoginTest();
		t1.login(userName, passKey);

		editEmployeeDetails emp = new editEmployeeDetails(driver);
		emp.clickPIM();
		emp.clickEmployeeList();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		emp.enterEmployeeName("peter mac");
		wait.until(ExpectedConditions.visibilityOf(emp.search_result));
		emp.seach_suggestion_click();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
		emp.clickSeach();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS) ;
		emp.click_search_result();
		log.info("search result clicked");
		//Thread.sleep(3000);

		
		wait.until(ExpectedConditions.visibilityOf(emp.personalInfo));
		emp.clickEdit();
		
		// putting some hard coded value
		emp.enterFirstName("Peter");
		emp.enterMiddleName("Mac");
		emp.enterLastName("Anderson");
		emp.enterLicense("5063940");
		emp.clickLicenseExpiry();

		DropDownSelect.dropdownByVisibleText(emp.licenseExpiryMonth, "Jun");
		DropDownSelect.dropdownByVisibleText(emp.licenseExpiryYear, "1984");
		emp.licenseExpiryDay.click();

		emp.clickMaleRadio();
		DropDownSelect.dropdownByIndex(emp.maritalStatus, 1);

		DropDownSelect.dropdownByVisibleText(emp.nationality, "American");

		emp.saveButton.click();


		wait.until(ExpectedConditions.visibilityOf(editEmployeeDetails.confirmationText));
		String fadable_message=editEmployeeDetails.confirmationText.getText();


		if(fadable_message.contains("Successfully Saved"))
		{
			Assert.assertTrue(true);
			log.info("adding successful");
			log.info("test passed");
		}
		else
		{
			takeScreenshot(driver, "editInfo");
			Assert.assertTrue(false);
			log.info("test failed");
		}



	}


}
