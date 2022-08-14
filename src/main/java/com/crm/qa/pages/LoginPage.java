package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//page factory-- OR(object repo):
	@FindBy(name= "email")
	WebElement email;
	
	@FindBy(name= "password")
	WebElement password;
	
	@FindBy(xpath = "//body/div[@id='ui']/div[1]/div[1]/form[1]/div[1]/div[3]")
	WebElement loginBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Log In')]")
	WebElement loginLink;
	
	@FindBy(xpath = "//span[contains(text(),'sign up')]")
	WebElement signUpBtn;
	
	
	//Initialization the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	
	public HomePage login(String un, String pwd) {
		loginLink.click();
		email.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
	
	
	
	
	
}
