package com.OrangeHRMAutomation.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporting extends TestListenerAdapter{

	public ExtentHtmlReporter exHtmlReporter;
	public ExtentReports exReports;
	public ExtentTest exTest;
	
	
	public void onStart(ITestContext testcontext) {
		
		//setting the name of the report
		String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName= "Test_Report-"+timeStamp+".html";
		
		
		exHtmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		exHtmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		
		exReports= new ExtentReports();
		
		exReports.attachReporter(exHtmlReporter);
		exReports.setSystemInfo("Host name", "localhost");
		exReports.setSystemInfo("Environment", "Windows 10");
		exReports.setSystemInfo("Tester", "Zinnun");
		
		exHtmlReporter.config().setDocumentTitle("OrangeHRM Test Project");
		exHtmlReporter.config().setReportName("Functional Test Report");
		exHtmlReporter.config().setTheme(Theme.DARK);
		
	}
	
	public void onTestSuccess(ITestResult tr) {
		exTest=exReports.createTest(tr.getName());
		exTest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		
	}
	
	public void onTestFailure(ITestResult tr){
	
		
		exTest=exReports.createTest(tr.getName());
		exTest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String screenshotPath= System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		System.out.println(screenshotPath);
		
		File f = new File(screenshotPath);
		
		if (f.exists()) {
			try 
			{
				exTest.fail("Screenshot is below: " + exTest.addScreenCaptureFromPath(screenshotPath));	
				
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		} 
		
	}
	
	public void onTestSkiped(ITestResult tr) {
		exTest=exReports.createTest(tr.getName());
		exTest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		
	}
	
	public void onFinish(ITestContext testcontext) {
		exReports.flush();
	}


	
	
}
