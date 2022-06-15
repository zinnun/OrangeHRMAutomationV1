package com.OrangeHRMAutomation.testcases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHRMAutomation.pageobjects.loginPage;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class TC_002_LogoDisplayed extends BaseClass{


	@Test
	public void logoCheck() throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(driver, 1);
		TC_001_LoginTest tc1 = new TC_001_LoginTest();
		tc1.login(userName, passKey);

		wait.until(ExpectedConditions.visibilityOf(loginPage.logo));
		log.info("logged in");

		// getting the path of the image LOGO in directory
		String imagePath=System.getProperty("user.dir")+"/src/test/java/com/OrangeHRMAutomation/testdata/logo.png";

		// reading the existing logo to compare
		BufferedImage sampleImage = ImageIO.read(new File(imagePath));
		log.info("sample Image read");

		// the path of the screenshot in directory
		String ssPath=System.getProperty("user.dir")+"/src/test/java/com/OrangeHRMAutomation/testdata/logoScreenshot.png";


		// deleting the screenshot if exists
		File ss = new File(ssPath);

		if(ss.exists()) {
			System.out.println("screenshot exists");
			ss.delete();
			System.out.println("screenshot deleted");
		}

		// taking screenshot the of the after login using aShot API
		WebElement theLogo=loginPage.logo;
		Screenshot logoSS = new AShot().takeScreenshot(driver, theLogo);
		log.info("screenshot taken");

		// writing the file in the directory
		ImageIO.write(logoSS.getImage(),"png",new File(ssPath));
		BufferedImage actualImage = logoSS.getImage();

		// creating ImageDiffer object to compare images
		ImageDiffer imgdif = new ImageDiffer();
		ImageDiff diff = imgdif.makeDiff(sampleImage, actualImage);
		log.info("Images have difference--> "+diff.hasDiff());
		Thread.sleep(3000);


		if( !diff.hasDiff())
		{
			Assert.assertTrue(true);
			log.info("Test Passed!!");
		}
		else
		{
			takeScreenshot(driver, "logoCheck");
			Assert.assertTrue(false);
			log.info("Test Failed");
		}




	}

}
