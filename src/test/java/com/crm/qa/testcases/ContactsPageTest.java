package com.crm.qa.testcases;


import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	
	
	String sheetName = "contacts";
	
	public ContactsPageTest() {
		super();  //is used to refer parent class constructors
		
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clikOnContactsLink();
		
	}
	
	@Test(priority = 1)
	public void verifyContactsPageLabelTest() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"contacts label is missing on the page");
	}
	
	@Test(priority = 2)
	public void selectSingleContactsTest() {
		contactsPage.selectContactsByName("hir Ramani");
	}
	@Test(priority = 3)
	public void selectMultipleContactsTest(){
		contactsPage.selectContactsByName("hir Ramani");
		contactsPage.selectContactsByName("hiren Ramani");
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority = 4, dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String firstName, String lastName, String company) throws InterruptedException {
		
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Tom", "Peter", "Google");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		contactsPage.createNewContact(firstName, lastName, company);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}  

		
}
