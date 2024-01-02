package com.crm.qa.tests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactsPage;


//@Listeners(ExtentReportListeners.class)
public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	NewContactsPage newContact;
	// TestUtils testUtils;

	// call the parent class constructor
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	// test cases should be independent of each other - no dependency on each other.
	// before each test case -- launch the browser and login
	// @Test -- execute the test case independently
	// after each test case -- close the browser

	@Test(priority = 1, enabled = true)
	public void verifyHomePageTitle() {
		String homePageTitle = homePage.verifyHomePageTitle(); // message will only display for failed tests.
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home page title not matched:");
	}

	@Test(priority = 2, enabled = true)
	public void verifyUserNameTest() {
		boolean usernameLable = homePage.verifyUsernameLable();
		Assert.assertTrue(usernameLable, "User name not matched");
	}

	@Test(priority = 3, enabled = true)
	public void contactsLinkTest() {
		contactsPage = homePage.clickOnNewContacts();
	}

	@Test(priority = 4)
	public void newContactLinkTest() {
		newContact = homePage.clickContactLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
