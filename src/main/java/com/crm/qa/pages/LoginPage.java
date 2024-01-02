 package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory / Object Repository OR
	@FindBy(name = "email")
	WebElement useremail;
	
	@FindBy(name = "password")
	WebElement userpassword;
	
	@FindBy(xpath = "//div[contains(text(),'Login')]")
	WebElement btnLogin;
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signUp;
	
	// how to initialize these OR - using PageFactory class:
	// create the constructor of this class which will execute and initialize the OR using the PageFactory class
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	// define different actions/methods
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public String validateSignupText() {
		return signUp.getText();
	}
	
	public HomePage doLogin(String uemail, String upwd) {
		useremail.sendKeys(uemail);
		userpassword.sendKeys(upwd);
		btnLogin.click();
		
		return new HomePage();
	}
	
	
	
}

