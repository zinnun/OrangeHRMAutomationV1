package com.OrangeHRMAutomation.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownSelect {

	public static void dropdownByVisibleText(WebElement element, String text) {
		Select sel= new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public static void dropdownByValue(WebElement element, String value) {
		Select sel= new Select(element);
		sel.selectByValue(value);
	}
	
	public static void dropdownByIndex(WebElement element, int index) {
		Select sel= new Select(element);
		sel.selectByIndex(index);
	}
}
