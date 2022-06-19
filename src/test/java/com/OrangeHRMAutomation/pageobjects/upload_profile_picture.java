package com.OrangeHRMAutomation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class upload_profile_picture{
	WebDriver driver;

	public upload_profile_picture(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath= "//b[contains(text(),'PIM')]")
	@CacheLookup
	WebElement PIM;

	@FindBy(xpath= "//a[contains(text(),'Linda Jane')]")
	@CacheLookup
	WebElement employee_name;


	@FindBy(xpath= "//img[@id='empPic']")
	@CacheLookup
	WebElement employee_photo;


	@FindBy(xpath= "//input[@id='photofile']")
	@CacheLookup
	WebElement choose_file;

	@FindBy(xpath= "//input[@id='btnSave']")
	@CacheLookup
	 WebElement upload_button;

	@FindBy(xpath = "//div[contains(@class, 'message success fadable') and contains(., 'Successfully Uploaded')]")
	@CacheLookup
	WebElement confirmationText;



	public  WebElement getConfirmationText() {
		return confirmationText;
	}

	public void clickPIM()
	{
		PIM.click();
	}

	public void click_employee()
	{
		employee_name.click();
	}

	public void click_employee_photo()
	{
		employee_photo.click();
	}

	public void sending_chosen_file(String photo_path)
	{
		choose_file.sendKeys(photo_path);
	}

	public void click_upload_button()
	{
		upload_button.click();
	}




}
