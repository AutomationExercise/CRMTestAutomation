package com.crm.qa.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtils;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtils testUtils;
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtils = new TestUtils();
		loginPage = new LoginPage();
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnNewContacts();
		
	}
	
	@Test(priority=1)
	public void contactsPageTitleTest() {
		String contactsPageTitle = contactsPage.verifyContactsPageTitle();
		Assert.assertEquals(contactsPageTitle, "Cogmento CRM");
	}
	
	@Test(priority=2)
	public void contactsLableTest() {
		//String contactsPageHeader = contactsPage.verifyContactsPageHeader();
		Assert.assertEquals(contactsPage.verifyContactsPageHeader(), "Contacts", "'Contacts' lable not matched");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
