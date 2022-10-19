package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
                                                                                //ctrl+shift+o shortcut for import
public class HomepageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	DealsPage dealspage;


	public HomepageTest() throws IOException {
		super();
	
	}
	
	// test cases should be separated and independent with each other.
	// before each test cases -- launch the browser and login
	//@test -- execute test case
	// after each test case -- close the browser
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException  
	{
		 initialization();
		 testutil= new TestUtil();
		 contactspage= new ContactsPage();
		 dealspage= new DealsPage();
		 loginpage = new LoginPage();
		 homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		 Thread.sleep(2000);
		
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String HomepageTitle= homepage.verifyHomePageTitle();  
		Assert.assertEquals(HomepageTitle,"CRMPRO");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest()
	{
		testutil.switchToFrame();
		Assert.assertTrue(homepage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLink() throws IOException
	{
		testutil.switchToFrame();
		contactspage= homepage.clickonContactsLink();
	}
	
	@Test(priority=4)
	public void verifyDealsLink() throws IOException
	{
		testutil.switchToFrame();
		dealspage= homepage.clickonDealsLink();
	}
	
	
	
	@AfterMethod
	public void teardown() 
	{
		driver.quit();
	}

}
