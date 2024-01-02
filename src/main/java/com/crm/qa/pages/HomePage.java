package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.utilities.TestUtils;

public class HomePage extends TestBase {

	// OR
	@FindBy(xpath = "//span[contains(@class,'user-display')]")
	WebElement usernameLable;

	@FindBy(xpath = "//span[@class='item-text' and contains(text(),'Contacts')]")
	private WebElement contactsLink;

	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//span[contains(text(),'/tasks')]")
	WebElement tasksLink;

	@FindBy(xpath = "//a[@class='item active']")
	WebElement home;

	//@FindBy(xpath = "//i[@class='plus inverted icon']")
	@FindBy(xpath = "//div[@id='main-nav']/div[3]/button/i")
	WebElement clickContactsPlusSign;

	// constructor
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// methods/actions
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}
	public ContactsPage clickOnNewContacts() {
		TestUtils.hoverTo(contactsLink); // mouse hover to contacts link on homepage.
		getContactsLink().click();
		return new ContactsPage();
	} 
	
	public NewContactsPage clickContactLink() {
		TestUtils.hoverTo(contactsLink);
		clickContactsPlusSign.click();
		return new NewContactsPage();
	}

	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasksLink() {
		dealsLink.click();
		return new TasksPage();
	}

	public boolean verifyUsernameLable() {
		return usernameLable.isDisplayed();
	}

	

}
