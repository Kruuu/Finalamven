package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	
	//Page factory : OR (Object Repository)
	@FindBy(name ="username")
	WebElement username;

	@FindBy(name="password")
	WebElement password;
	
	@FindBy (xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy (xpath="//a[contains(text(),'Sign Up')]")
	WebElement signupbtn;
	
	@FindBy (xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmlogo;
	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	
	// Initializing the page Objects
	public LoginPage() throws IOException 
	{
		PageFactory.initElements(driver, this);
	}
	
	// Actions:
	public String validateLoginPageTitle() 
	{
		return  driver.getTitle();
	}
	
	public boolean validateCrmImage() 
	{
		
		return crmlogo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd) throws IOException 
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		jse.executeScript("arguments[0].click();", loginBtn);
		//loginBtn.click();
		
		return new HomePage();
	}

}

