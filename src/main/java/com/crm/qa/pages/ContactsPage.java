package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	public ContactsPage() throws IOException {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath= "//td[contains(text(),'Contacts')]")
	WebElement contactsLable;
	
	@FindBy (id="first_name")
	WebElement firstname;
	
	@FindBy(id="surname")
	WebElement lastname;
	
	@FindBy(name="nickname")
	WebElement nickname;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement saveButton;
	
	public boolean verifyContactsLabel()
	{
		
		return contactsLable.isDisplayed();
		
	}
	
     public void selectContactsByName(String name)
     {
    	 driver.findElement(By.xpath("//a[text()='"+name+"']")).click();
     }
     
     public void createNewContact(String title, String ftname, String ltname,String nkname)
     {
    	 Select select = new Select(driver.findElement(By.name("title")));
    	 select.selectByVisibleText(title);
    	 firstname.sendKeys(ftname);
    	 lastname.sendKeys(ltname);
    	 nickname.sendKeys(nkname);
    	 saveButton.click();
     }
}
