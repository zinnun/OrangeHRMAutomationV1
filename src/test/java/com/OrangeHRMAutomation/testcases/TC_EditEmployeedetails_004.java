package com.OrangeHRMAutomation.testcases;

import org.testng.annotations.Test;

import com.OrangeHRMAutomation.pageobjects.editEmployeeDetails;
import com.OrangeHRMAutomation.utilities.DropDownSelect;

public class TC_EditEmployeedetails_004 extends BaseClass{
	
	@Test
	public void editInfo() throws InterruptedException {
		
//	TC_LoginTest_001 loginPage = new TC_LoginTest_001();	
//	loginPage.login();
	
		//TC_LoginTest_001.login(userName, passKey);
		TC_LoginTest_001 t1 = new TC_LoginTest_001();
		t1.login(userName, passKey);
		
		editEmployeeDetails emp = new editEmployeeDetails(driver);
		emp.clickPIM();
		emp.clickEmployeeList();
		Thread.sleep(2000);
		emp.clickExpEmployee();
		Thread.sleep(3000);
		
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
		
		//Thread.sleep(1000);
		
//		Actions act = new Actions(driver);
//		act.moveToElement(emp.confirmation).perform();
		
		
//		boolean conf = emp.confirmationText.isDisplayed();
//		System.out.println(conf);
		
		/*
		if (conf.equals("Successfully Saved ")) {
			Assert.assertTrue(true);
			log.info("test passed");
		}else {
			Assert.assertTrue(false);
			log.info("test failed");
		}
		/*
		emp.clickSeach();
		
		Thread.sleep(3000);
		
		emp.clickExpEmployee();
		boolean confirm= driver.getPageSource().contains("Peter Mac Anderson");
		
		if (confirm==true) {
			
			Assert.assertTrue(true);
			log.info("test passed");
		}
		else {
			Assert.assertTrue(false);
			log.info("test failed");
		}
		
		*/
		
		
		
		
		
		
	}
	

}
