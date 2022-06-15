package com.OrangeHRMAutomation.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.OrangeHRMAutomation.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Logger log;


	ReadConfig rc= new ReadConfig();
	public String baseUrl = rc.getURl();
	public String userName = rc.getUserName();
	public String passKey = rc.getPassword();


	@Parameters("browser")
	@BeforeClass
	public void openBrowser(String parameter)	//the parameter comes from TestNG.xml
	{
		log = Logger.getLogger("OrangeHRM");
		PropertyConfigurator.configure("log4j.properties");

		if(parameter.equalsIgnoreCase("chrome"))
		{
			//System.setProperty(rc.getChrome(), rc.getChromePath());
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(parameter.equalsIgnoreCase("firefox"))
		{
			//System.setProperty(rc.getFirefox(), rc.getFirefoxPath());
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			//System.setProperty(rc.getEdge(),rc.getEdgeKey());
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		log.info("Test initiated, browser launched");
		driver.get(baseUrl);
		log.info("url opened");

	}

	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
		log.info("browser closed");
	}

	public void takeScreenshot(WebDriver driver, String tname) throws IOException {

		String screenshotPath= System.getProperty("user.dir")+"/Screenshots/"+ tname +".png";
	//	System.out.println(screenshotPath);

			TakesScreenshot ts= (TakesScreenshot) driver;
			File source= ts.getScreenshotAs(OutputType.FILE);

			File dest = new File(screenshotPath);
			FileUtils.copyFile(source, dest);

			log.info("screenshot taken");
	}

}
