package com.OrangeHRMAutomation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addEmployeePage {

	public WebDriver driver;

	public addEmployeePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath= "//b[contains(text(),'PIM')]")
	@CacheLookup
	WebElement PIM;

	@FindBy(xpath= "//a[@id='welcome']")
	@CacheLookup
	WebElement account;

	@FindBy(xpath= "//a[@href='/index.php/auth/logout']") 
	@CacheLookup
	WebElement logout;

	@FindBy(xpath= "//a[@id='menu_pim_addEmployee']")
	@CacheLookup
	WebElement addEmployee;


	@FindBy(xpath= "//input[@id='firstName']")
	@CacheLookup
	WebElement firstName;

	@FindBy(xpath= "//input[@id='middleName']")
	@CacheLookup
	WebElement middleName;

	@FindBy(xpath= "//input[@id='lastName']")
	@CacheLookup
	WebElement lastname;

	@FindBy(xpath= "//input[@id='employeeId']")
	@CacheLookup
	WebElement employeeID;

	@FindBy(xpath= "//input[@id='btnSave']")
	@CacheLookup
	WebElement saveButton;
	
	@FindBy(xpath="//input[@id='txtUsername']")
	@CacheLookup
	WebElement txtUsername;


	//Actions act = new Actions(driver);
	
	public WebElement getPIM() {
		return PIM;
	}

	public WebElement getAccount() {
		return account;
	}

	public WebElement getLogout() {
		return logout;
	}

	public WebElement getAddEmployee() {
		return addEmployee;
	}

	public WebElement getTxtUsername() {
		return txtUsername;
	}

	public void enterFirstName(String fName)
	{
		firstName.sendKeys(fName);
	}

	public void demoMethod(WebElement element)
	{
		element.click();
	}

	public void enterMiddletName(String mName)
	{
		middleName.sendKeys(mName);
	}

	public void enterLastName(String lName)
	{
		lastname.sendKeys(lName);
	}

	public void enterEmployeeID(int id)
	{
		employeeID.clear();
		employeeID.sendKeys(String.valueOf(id));
	}

	public void clickSaveButton()
	{
		saveButton.click();
	}





}
