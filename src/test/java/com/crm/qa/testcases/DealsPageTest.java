package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends TestBase {
	
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	DealsPage dealspage;
	
	String sheetName="Deals";

	public DealsPageTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws IOException   {
		 initialization();
		 
		 testutil= new TestUtil();
		 contactspage= new ContactsPage();
		 loginpage = new LoginPage();
		 dealspage= new DealsPage();
		 homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		 testutil.switchToFrame();
		 dealspage = homepage.clickonDealsLink();
	}
	
	@Test(priority=1)

	public void verifyDealsPageLabel()
	{
		Assert.assertTrue(dealspage.verifyDealaLable());
	
	}
	
	

	@AfterMethod
	public void teardown() 
	{
		driver.quit();
	}
}
