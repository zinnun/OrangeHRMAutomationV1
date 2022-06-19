package com.OrangeHRMAutomation.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.OrangeHRMAutomation.pageobjects.editEmployeeDetails;
import com.OrangeHRMAutomation.utilities.AllureReporting;
import com.OrangeHRMAutomation.utilities.DropDownSelect;

@Listeners({AllureReporting.class})
public class TC_004_EditEmployeedetails extends BaseClass{

	@Test
	public void editInfo() throws InterruptedException, IOException {

		WebDriverWait wait = new WebDriverWait(driver, 4);
		TC_001_LoginTest t1 = new TC_001_LoginTest();
		t1.login(userName, passKey);

		editEmployeeDetails emp = new editEmployeeDetails(driver);
		emp.clickPIM();
		emp.clickEmployeeList();
		//driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		Thread.sleep(2000);
		emp.enterEmployeeName("peter mac");
		Thread.sleep(2000);
		//driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
		emp.seach_suggestion_click();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
		emp.clickSearch();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS) ;
		emp.click_search_result();
		log.info("search result clicked");
		
		wait.until(ExpectedConditions.visibilityOf(emp.getPersonalInfo()));
		emp.clickEdit();
		
		// putting some hard coded value
		emp.enterFirstName("Peter");
		emp.enterMiddleName("Mac");
		emp.enterLastName("Anderson");
		emp.enterLicense("5063940");
		emp.clickLicenseExpiry();

		DropDownSelect.dropdownByVisibleText(emp.getLicenseExpiryMonth(), "Jun");
		DropDownSelect.dropdownByVisibleText(emp.getLicenseExpiryYear(), "1984");
		emp.getLicenseExpiryDay().click();

		emp.clickMaleRadio();
		DropDownSelect.dropdownByIndex(emp.getMaritalStatus(), 1);

		DropDownSelect.dropdownByVisibleText(emp.getNationality(), "American");

		emp.getSaveButton().click();


		wait.until(ExpectedConditions.visibilityOf(editEmployeeDetails.getConfirmationText()));
		String fadable_message=editEmployeeDetails.getConfirmationText().getText();


		if(fadable_message.contains("Successfully Saved"))
		{
			Assert.assertTrue(true);
			log.info("adding successful");
			log.info("test passed");
		}
		else
		{
			takeScreenshot(driver, "editInfo");
			driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS) ;
			Assert.assertTrue(false);
			log.info("test failed");
		}



	}


}
