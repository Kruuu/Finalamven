package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase {

	public DealsPage() throws IOException {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//td[contains(text(),'Deals')]")
	WebElement DealsLable;
	

	

	public  boolean verifyDealaLable() {
		
		return DealsLable.isDisplayed();
	}

	
	
}

