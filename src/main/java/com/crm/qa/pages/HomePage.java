package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	
	@FindBy(xpath = "//b[contains(text(),'Hiren')]")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath = "//span[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[3]/button[1]")
	WebElement newContactsLink;
	
	
	
	
	//Initialization the page objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyUserName() {
		return userNameLabel.isDisplayed();
	}
	
	
	public ContactsPage clikOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public void clickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[1]/div[1]")));
		newContactsLink.click();
		}
	
		
	public DealsPage clikOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clikOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
}
