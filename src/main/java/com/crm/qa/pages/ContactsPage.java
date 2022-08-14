package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	Actions actions = new Actions(driver);

	@FindBy(xpath = "//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]")
	WebElement contactsLabel;
	
	@FindBy(xpath = "//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath= "//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[2]/div[2]/div[1]/div[1]/input[1]")
	WebElement compa; 
	
	@FindBy(xpath= "//button[@class='ui linkedin button' and contains(text(),'Save')]")
	WebElement saveBtn; 
	
	
	
	//Initialization the page objects
	public ContactsPage() {
			PageFactory.initElements(driver, this);
		}
	
		
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	 
	public  void selectContactsByName(String name) {
		WebElement element = driver.findElement(By.xpath("//a[text()='hir Ramani']//parent::td//following-sibling::td[3]"));
		actions.moveToElement(element).build().perform();
		
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td/div")).click();
		}
	
	
	public void createNewContact(String fName, String lName, String comp) throws InterruptedException {
		//WebDriverWait wait = new WebDriverWait(driver,20);
		//wait.until(ExpectedConditions.elementToBeClickable(lastName));
		Actions action = new Actions(driver);
		action.moveToElement(lastName);
		//Thread.sleep(1000);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		compa.sendKeys(comp);
		saveBtn.click();
		}
	
	
}
