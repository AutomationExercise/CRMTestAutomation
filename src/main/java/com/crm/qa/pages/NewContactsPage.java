package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class NewContactsPage extends TestBase {
	
	
	//OR
	@FindBy(xpath = "//span[@class='selectable ']")
	WebElement createContactLabel;
	
	@FindBy(name = "first_name")
	WebElement firstName;
	
	@FindBy(name = "last_name")
	WebElement lastsName;
	
	@FindBy(name = "company")
	WebElement company;
	
	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement btnSave;
	
	public NewContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	public boolean createNewContactLableDisplayed() {
		return createContactLabel.isDisplayed();
	}
	
	public void createNewContact(String fName, String lName) {
		firstName.sendKeys(fName);
		lastsName.sendKeys(lName);
		//company.sendKeys(comp);
		
	
		
		btnSave.click();
	}
	
//	public void createNewContact(String fName, String lName, String status) throws InterruptedException {
//		firstName.sendKeys(fName);
//		lastsName.sendKeys(lName);
//		//company.sendKeys(comp);
//		Thread.sleep(3000);
//		Select select = new Select(driver.findElement(By.name("status")));
//		select.selectByVisibleText(status);
//		
//		btnSave.click();
//	}
	
	
}
