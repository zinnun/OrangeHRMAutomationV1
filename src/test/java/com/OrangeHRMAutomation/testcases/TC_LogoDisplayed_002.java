package com.OrangeHRMAutomation.testcases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHRMAutomation.pageobjects.addEmployeePage;
import com.OrangeHRMAutomation.pageobjects.loginPage;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class TC_LogoDisplayed_002 extends BaseClass{

	@Test
	public void logoCheck() throws InterruptedException, IOException
	{
	loginPage lp = new loginPage(driver);
	lp.setUsername(userName);
	lp.setPassword(passKey);
	lp.clickLoginButton();
	Thread.sleep(3000);
	log.info("logged in");
	
	WebDriverWait wait = new WebDriverWait(driver, 1);
	wait.until(ExpectedConditions.visibilityOf(loginPage.logo));
	
	//boolean logOutButton = lp.logOut.isDisplayed();
	String imagePath=System.getProperty("user.dir")+"/src/test/java/com/OrangeHRMAutomation/testdata/logo.png";
	
	BufferedImage sampleImage = ImageIO.read(new File(imagePath));
	log.info("sample Image read");
	
	WebElement element=driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='branding']/a[1]/img[1]"));
	Screenshot logoSS = new AShot().takeScreenshot(driver, element);
	
	//ImageIO.write(logoSS.getImage(),"png",new File(System.getProperty("user.dir") +"\\src\\test\\java\\com\\OrangeHRMAutomation\\testdata\\logoScreenshot.png"));
	BufferedImage actualImage = logoSS.getImage();
	
	ImageDiffer imgdif = new ImageDiffer();
	ImageDiff diff = imgdif.makeDiff(sampleImage, actualImage);
			
	Thread.sleep(3000);

	
	if( diff.hasDiff()==false)
	{
		Assert.assertTrue(true);
		log.info("Test Passed");
	}
	else 
	{
		Assert.assertTrue(false);
		log.info("Test Failed");
	}
	
	
	}
	
}
