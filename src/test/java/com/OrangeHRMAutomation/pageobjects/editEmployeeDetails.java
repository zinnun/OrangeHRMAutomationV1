package com.OrangeHRMAutomation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class editEmployeeDetails {


	WebDriver driver;
	
	public editEmployeeDetails(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//b[contains(text(),'PIM')]")
	@CacheLookup
	public WebElement PIM;	
	
	@FindBy(xpath= "//a[@id='menu_pim_viewEmployeeList']")
	@CacheLookup
	public  WebElement employeeList;
	
	@FindBy(xpath= "//input[@id='empsearch_employee_name_empName']")
	@CacheLookup
	WebElement searchName;
	
	@FindBy(xpath= "//input[@id='searchBtn']")
	@CacheLookup
	WebElement searchButton;
	
	@FindBy(xpath= "//a[contains(text(),'Peter Mac')]")
	@CacheLookup
	WebElement expEmployee;
	
	@FindBy(xpath= "//input[@id='btnSave'][@value='Edit']")
	@CacheLookup
	WebElement editButton;
	
	@FindBy(xpath= "//input[@id='personal_txtEmpFirstName']")
	@CacheLookup
	public WebElement firstName;
	
	@FindBy(xpath="//input[@id='personal_txtEmpMiddleName']")
	@CacheLookup
	public  WebElement middleName;
	
	@FindBy(xpath="//input[@id='personal_txtEmpLastName']")
	@CacheLookup
	public  WebElement lastName;
	
	@FindBy(xpath = "//input[@id='personal_txtLicenNo']")
	@CacheLookup
	WebElement drivingLicense;

	@FindBy(xpath = "//body/div[@id='wrapper']/div[@id='content']/div[@id='employee-details']/div[@id='pdMainContainer']/div[2]/form[1]/fieldset[1]/ol[2]/li[4]/img[1]")
	@CacheLookup
	WebElement licenseExpiry;
	
	@FindBy(xpath = "//body/div[@id='ui-datepicker-div']/div[1]/div[1]/select[2]")
	@CacheLookup
	public  WebElement licenseExpiryYear;
	
	@FindBy(xpath = "//body/div[@id='ui-datepicker-div']/div[1]/div[1]/select[1]")
	@CacheLookup
	public  WebElement licenseExpiryMonth;
	
	@FindBy(xpath = "//tr//a[contains(text(),'12')]")
	@CacheLookup
	public  WebElement licenseExpiryDay;
	
	@FindBy(xpath = "//label[contains(text(),'Male')]")
	@CacheLookup
	WebElement maleRadio;
	
	@FindBy(xpath = "//label[contains(text(),'Female')]")
	@CacheLookup
	WebElement femaleRadio;
	
	@FindBy(xpath = "//select[@id='personal_cmbMarital']")
	@CacheLookup
	public WebElement maritalStatus;
	
	@FindBy(xpath = "//select[@id='personal_cmbNation']")
	@CacheLookup
	public WebElement nationality;
	
	@FindBy(xpath = "//body/div[@id='wrapper']/div[@id='content']/div[@id='employee-details']/div[@id='pdMainContainer']/div[2]/form[1]/fieldset[1]/ol[3]/li[4]/img[1]")
	@CacheLookup
	WebElement DOB;
	
	@FindBy(xpath = "//body/div[@id='wrapper']/div[@id='content']/div[@id='employee-details']/div[@id='pdMainContainer']/div[2]/form[1]/fieldset[1]/ol[3]/li[4]/img[1]")
	@CacheLookup
	WebElement DOB_Year;
	
	@FindBy(xpath = "//body/div[@id='wrapper']/div[@id='content']/div[@id='employee-details']/div[@id='pdMainContainer']/div[2]/form[1]/fieldset[1]/ol[3]/li[4]/img[1]")
	@CacheLookup
	WebElement DOB_Month;
	
	@FindBy(xpath = "//img[@id='empPic']")
	@CacheLookup
	WebElement ProfilePicture;
	
	@FindBy(xpath = "//input[@id='btnSave']")
	@CacheLookup
	public WebElement saveButton;
	
	@FindBy(xpath = "//script[contains(text(),'div.fadable')]")
	@CacheLookup
	public WebElement confirmation;
	
	@FindBy(xpath = "//*[contains(text(),'Successfully Saved')]")
	@CacheLookup
	public WebElement confirmationText;
	
	//div[contains(text(), ' Successfully Saved')]
	
	
	
	
	
	
	
	
	public void clickPIM()
	{
		PIM.click();
	}
	
	public void clickEmployeeList()
	{
		employeeList.click();
	}
	
	public void enterEmployeeName(String name)
	{
		searchName.click();
		searchName.sendKeys(name);
	}
	
//	public void enterEmployeeName(String name)
//	{
//		searchName.sendKeys(name);
//	}
	
	public void clickSeach()
	{
		searchButton.click();
	}
	
	public void clickExpEmployee()
	{
		expEmployee.click();
	}

	public void clickEdit()
	{
		editButton.click();
	}
	
	
	public void enterFirstName(String name)
	{
		firstName.clear();
		firstName.sendKeys(name);
	}
	
	public void enterMiddleName(String name)
	{
		middleName.clear();
		middleName.sendKeys(name);
	}
	
	public void enterLastName(String name)
	{
		lastName.clear();
		lastName.sendKeys(name);
	}
	
	public void enterLicense(String license)
	{
		drivingLicense.clear();
		drivingLicense.sendKeys(license);
	}
	
	public void clickLicenseExpiry()
	{
		licenseExpiry.click();
	}
	
	public void clickMaleRadio()
	{
		maleRadio.click();
	}
	
	public void clickDOB()
	{
		DOB.click();
	}
	
	
	
	
}























