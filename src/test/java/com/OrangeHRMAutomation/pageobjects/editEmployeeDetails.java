package com.OrangeHRMAutomation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class editEmployeeDetails {

	public WebDriver driver;

	public editEmployeeDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//b[contains(text(),'PIM')]")
	@CacheLookup
	WebElement PIM;

	@FindBy(xpath = "//a[@id='menu_pim_viewEmployeeList']")
	@CacheLookup
	WebElement employeeList;

	@FindBy(xpath = "//input[@id='empsearch_employee_name_empName']")
	@CacheLookup
	WebElement searchName;

	@FindBy(xpath = "//li[@class='ac_even ac_over']")
	WebElement search_name_suggestion;

	@FindBy(xpath = "//input[@id='searchBtn']")
	@CacheLookup
	WebElement searchButton;

	@FindBy(xpath = "//div[@id='tableWrapper']/table/tbody/tr/td[3]/a")
	WebElement search_result;

	@FindBy(xpath = "//input[@id='btnSave'][@value='Edit']")
	@CacheLookup
	WebElement editButton;

	@FindBy(xpath = "//input[@id='personal_txtEmpFirstName']")
	@CacheLookup
	WebElement firstName;

	@FindBy(xpath = "//input[@id='personal_txtEmpMiddleName']")
	@CacheLookup
	WebElement middleName;

	@FindBy(xpath = "//input[@id='personal_txtEmpLastName']")
	@CacheLookup
	WebElement lastName;

	@FindBy(xpath = "//input[@id='personal_txtLicenNo']")
	@CacheLookup
	WebElement drivingLicense;

	@FindBy(xpath = "//body/div[@id='wrapper']/div[@id='content']/div[@id='employee-details']/div[@id='pdMainContainer']/div[2]/form[1]/fieldset[1]/ol[2]/li[4]/img[1]")
	@CacheLookup
	WebElement licenseExpiry;

	@FindBy(xpath = "//body/div[@id='ui-datepicker-div']/div[1]/div[1]/select[2]")
	@CacheLookup
	WebElement licenseExpiryYear;

	@FindBy(xpath = "//body/div[@id='ui-datepicker-div']/div[1]/div[1]/select[1]")
	@CacheLookup
	WebElement licenseExpiryMonth;

	@FindBy(xpath = "//tr//a[contains(text(),'12')]")
	@CacheLookup
	WebElement licenseExpiryDay;

	@FindBy(xpath = "//label[contains(text(),'Male')]")
	@CacheLookup
	WebElement maleRadio;

	@FindBy(xpath = "//label[contains(text(),'Female')]")
	@CacheLookup
	WebElement femaleRadio;

	@FindBy(xpath = "//select[@id='personal_cmbMarital']")
	@CacheLookup
	WebElement maritalStatus;

	@FindBy(xpath = "//select[@id='personal_cmbNation']")
	@CacheLookup
	WebElement nationality;

	@FindBy(xpath = "//body/div[@id='wrapper']/div[@id='content']"
			+ "/div[@id='employee-details']/div[@id='pdMainContainer']"
			+ "/div[2]/form[1]/fieldset[1]/ol[3]/li[4]/img[1]")
	@CacheLookup
	WebElement DOB;

	@FindBy(xpath = "//body/div[@id='wrapper']/div[@id='content']"
			+ "/div[@id='employee-details']/div[@id='pdMainContainer']"
			+ "/div[2]/form[1]/fieldset[1]/ol[3]/li[4]/img[1]")
	@CacheLookup
	WebElement DOB_Year;

	@FindBy(xpath = "//body/div[@id='wrapper']/div[@id='content']"
			+ "/div[@id='employee-details']/div[@id='pdMainContainer']"
			+ "/div[2]/form[1]/fieldset[1]/ol[3]/li[4]/img[1]")
	@CacheLookup
	WebElement DOB_Month;

	@FindBy(xpath = "//img[@id='empPic']")
	@CacheLookup
	WebElement ProfilePicture;

	@FindBy(xpath = "//input[@id='btnSave']")
	@CacheLookup
	WebElement saveButton;

	@FindBy(xpath = "//div[contains(@class, 'message success fadable') and contains(., 'Successfully Saved')]")
	@CacheLookup
	WebElement confirmationText;

	@FindBy(xpath = "//h1[contains(text(),'Personal Details')]")
	@CacheLookup
	WebElement personalInfo;




	public WebElement getPIM() {
		return PIM;
	}

	public WebElement getEmployeeList() {
		return employeeList;
	}

	public WebElement getSearch_name_suggestion() {
		return search_name_suggestion;
	}

	public WebElement getSearch_result() {
		return search_result;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getMiddleName() {
		return middleName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getLicenseExpiryYear() {
		return licenseExpiryYear;
	}

	public WebElement getLicenseExpiryMonth() {
		return licenseExpiryMonth;
	}

	public WebElement getLicenseExpiryDay() {
		return licenseExpiryDay;
	}

	public WebElement getMaritalStatus() {
		return maritalStatus;
	}

	public WebElement getNationality() {
		return nationality;
	}

	public WebElement getDOB() {
		return DOB;
	}

	public WebElement getDOB_Year() {
		return DOB_Year;
	}

	public WebElement getDOB_Month() {
		return DOB_Month;
	}

	public WebElement getProfilePicture() {
		return ProfilePicture;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getConfirmationText() {
		return confirmationText;
	}

	public WebElement getPersonalInfo() {
		return personalInfo;
	}

	public void clickPIM() {
		PIM.click();
	}

	public void clickEmployeeList() {
		employeeList.click();
	}

	public void enterEmployeeName(String name) {
		searchName.click();
		searchName.clear();
		searchName.sendKeys(name);
	}

	public void seach_suggestion_click() {
		search_name_suggestion.click();
	}

	// public void enterEmployeeName(String name)
	// {
	// searchName.sendKeys(name);
	// }

	public void clickSearch() {
		searchButton.click();
	}

	public void click_search_result() {
		search_result.click();
	}

	public void clickEdit() {
		editButton.click();
	}

	public void enterFirstName(String name) {
		firstName.clear();
		firstName.sendKeys(name);
	}

	public void enterMiddleName(String name) {
		middleName.clear();
		middleName.sendKeys(name);
	}

	public void enterLastName(String name) {
		lastName.clear();
		lastName.sendKeys(name);
	}

	public void enterLicense(String license) {
		drivingLicense.clear();
		drivingLicense.sendKeys(license);
	}

	public void clickLicenseExpiry() {
		licenseExpiry.click();
	}

	public void clickMaleRadio() {
		maleRadio.click();
	}

	public void clickDOB() {
		DOB.click();
	}

}
