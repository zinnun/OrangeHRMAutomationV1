package com.OrangeHRMAutomation.testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHRMAutomation.pageobjects.editEmployeeDetails;
import com.OrangeHRMAutomation.utilities.DropDownSelect;

public class TC_EditEmployeedetails_004 extends BaseClass{
	
	@Test
	public void editInfo() throws InterruptedException {
		
		TC_LoginTest_001 t1 = new TC_LoginTest_001();
		t1.login(userName, passKey);
		
		editEmployeeDetails emp = new editEmployeeDetails(driver);
		emp.clickPIM();
		emp.clickEmployeeList();
		Thread.sleep(2000);
		emp.enterEmployeeName("peter mac");
		Thread.sleep(2000);
		emp.seach_suggestion_click();
		Thread.sleep(2000);
		emp.clickSeach();
		Thread.sleep(3000);
		emp.click_search_result();
		log.info("search result clicked");
		//Thread.sleep(3000);
		
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(editEmployeeDetails.personalInfo));
		emp.clickEdit();
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
		

		

		
		wait = new WebDriverWait(driver, 10);
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
			Assert.assertTrue(false);
			log.info("test failed");
		}	
		
		
		
	}
	

}
