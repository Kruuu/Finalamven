package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	
	
	@FindBy (xpath="//td[contains(text(),'User: Kruti Patel')]")
	WebElement userNameLable;
	
	@FindBy (xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy (xpath="//a[@title='Deals']")
	WebElement DealsLink;
	
	@FindBy (xpath="//a[@title='Tasks']")
	WebElement tasksLink;
	
	@FindBy (xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	

	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);

	}
	
	public String verifyHomePageTitle() 
	{
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName()
	{
		 return userNameLable.isDisplayed();
	}
	
	public ContactsPage clickonContactsLink() throws IOException
	{
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickonDealsLink() throws IOException
	{
		DealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickonTasksLink() throws IOException
	{
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink()
	{
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}
	
	
}
