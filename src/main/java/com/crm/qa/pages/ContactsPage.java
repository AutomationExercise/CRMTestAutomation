package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	//OR
	@FindBy(xpath="//span[@class='selectable ']")
	WebElement contactsLable;
	
	// constructor
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	//actions
	public String verifyContactsPageTitle() {
		return driver.getTitle();
	}
	
	public String verifyContactsPageHeader() {
		return contactsLable.getText();
	}
	
	

}
