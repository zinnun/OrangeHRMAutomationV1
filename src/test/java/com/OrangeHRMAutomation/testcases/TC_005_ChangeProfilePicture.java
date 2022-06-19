package com.OrangeHRMAutomation.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.OrangeHRMAutomation.pageobjects.upload_profile_picture;
import com.OrangeHRMAutomation.utilities.AllureReporting;

@Listeners({AllureReporting.class})
public class TC_005_ChangeProfilePicture extends BaseClass{

	@Test
	public void changeProfilePicture() throws InterruptedException, IOException {

		TC_001_LoginTest login = new TC_001_LoginTest();
		login.login(userName, passKey);

		upload_profile_picture upload_photo = new upload_profile_picture(driver);
		upload_photo.clickPIM();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
		upload_photo.click_employee();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
		upload_photo.click_employee_photo();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS) ;

		String picture_path=System.getProperty("user.dir")+
				"/src/test/java/com/OrangeHRMAutomation/testdata/profile_picture.jpg";	//profile_picture.jpg
		upload_photo.sending_chosen_file(picture_path);
		log.info("uploading photo");
		upload_photo.click_upload_button();
		log.info("photo uploaded");


		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(upload_photo.getConfirmationText()));
		String fadable_message=upload_photo.getConfirmationText().getText();
		System.out.println(fadable_message);



		if(fadable_message.contains("Successfully Uploaded"))
		{
			Assert.assertTrue(true);
			log.info("Uploading Profile Picture successfully");
			log.info("test passed");
		}
		else
		{
			takeScreenshot(driver, "changeProfilePicture");
			driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS) ;
			Assert.assertTrue(false);
			log.info("test failed");
		}



	}

}
