package com.OrangeHRMAutomation.testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.OrangeHRMAutomation.utilities.ReadConfig;

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
		PropertyConfigurator.configure("Log4j.properties");
		
		if(parameter.equalsIgnoreCase("chrome")) 
		{
		System.setProperty(rc.getChrome(), rc.getChromePath());
		driver = new ChromeDriver();
		}
		else if(parameter.equalsIgnoreCase("firefox"))
		{
			System.setProperty(rc.getFirefox(), rc.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		else {
			System.setProperty(rc.getEdge(),rc.getEdgeKey());
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		log.info("Test initiated, browser launched");
		driver.get(baseUrl);
		log.info("url opend");
		
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
		log.info("browser closed");
	}

}
