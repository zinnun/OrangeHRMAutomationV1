package com.OrangeHRMAutomation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class loginPage {

	WebDriver driver;

	public loginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='txtUsername']")
	@CacheLookup
	WebElement txtUsername;

	@FindBy(xpath= "//input[@id='txtPassword']")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(xpath = "//input[@id='btnLogin']")
	@CacheLookup
	WebElement loginButton;

	@FindBy(xpath= "//a[contains(text(),'Logout')]")
	@CacheLookup
	WebElement logOut;


	@FindBy(xpath= "//span[contains(text(),'Invalid credentials')]")
	@CacheLookup
	WebElement invalidMesage;

	@FindBy(xpath="//body/div[@id='wrapper']/div[@id='branding']/a[1]/img[1]")
	@CacheLookup
	WebElement logo;


	@FindBy(xpath="//a[@id='menu_dashboard_index']")
	@CacheLookup
	WebElement dashBoard;


	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getLogOut() {
		return logOut;
	}

	public WebElement getInvalidMesage() {
		return invalidMesage;
	}

	public WebElement getLogo() {
		return logo;
	}

	public WebElement getDashBoard() {
		return dashBoard;
	}

	public void setUsername(String name)
	{
		txtUsername.sendKeys(name);
	}

	public void setPassword(String pass)
	{
		txtPassword.sendKeys(pass);
	}

	public void clickLoginButton()
	{
		loginButton.click();
	}

	public void logOut()
	{
		logOut.click();
	}
}
