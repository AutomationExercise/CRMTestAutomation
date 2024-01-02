package com.crm.qa.tests;

import java.io.FileInputStream;
import java.nio.file.FileSystemNotFoundException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactsPage;
import com.crm.qa.utilities.TestUtils;

public class NewContactPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	NewContactsPage newContact;
	
	String SheetName = "contacts";
	
	NewContactPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		newContact = homePage.clickContactLink();
	}
	
//	@Test(priority=1)
//	public void newContactLableTest() {
//		boolean newContactLable = newContact.createNewContactLableDisplayed();
//	 Assert.assertTrue(newContactLable);
//	}
	
	@DataProvider(name = "getCRMTestData")
	public Object[][] getCRMTestData() {
	 Object data[][] = TestUtils.getTestData(SheetName);
	 return data;
	}
	
	@Test(priority=3, dataProvider = "getCRMTestData")
	public void validateCreateNewContactTest(String firstName, String lastName)  {
		newContact.createNewContact(firstName, lastName);
	}
	
	@Test(priority=2)
	 public void validateCreateNewContact() {
		newContact.createNewContact("Sohail", "Ahmad");
	}
	
//	@Test(priority=2)
//	public void validateCreateNewContactTest() throws InterruptedException{
//		newContact.createNewContact("Sohail", "Ahmad", "Active");
//	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
