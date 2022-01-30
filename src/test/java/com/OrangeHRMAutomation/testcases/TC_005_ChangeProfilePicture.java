package com.OrangeHRMAutomation.testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHRMAutomation.pageobjects.upload_profile_picture;

public class TC_005_ChangeProfilePicture extends BaseClass{
	
	@Test
	public void changeProfilePicture() throws InterruptedException {

		TC_001_LoginTest login = new TC_001_LoginTest();
		login.login(userName, passKey);
		
		upload_profile_picture upload_photo = new upload_profile_picture(driver);
		upload_photo.clickPIM();
		Thread.sleep(3000);
		upload_photo.click_employee();
		Thread.sleep(2000);
		upload_photo.click_employee_photo();
		Thread.sleep(3000);
		
		String picture_path=System.getProperty("user.dir")+
				"/src/test/java/com/OrangeHRMAutomation/testdata/profile_picture.jpg";
		upload_photo.sending_choose_file(picture_path);
		log.info("uploading photo");
		upload_photo.click_upload_button();
		log.info("photo uploaded");
		
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(upload_profile_picture.confirmationText)); 
		String fadable_message=upload_profile_picture.confirmationText.getText();
		System.out.println(fadable_message);

		
		
		if(fadable_message.contains("Successfully Uploaded"))
		{
			Assert.assertTrue(true);
			log.info("Uploading Profile Picture successfully");
			log.info("test passed");
		}
		else
		{
			Assert.assertTrue(false);
			log.info("test failed");
		}	

		
		
	}

}
