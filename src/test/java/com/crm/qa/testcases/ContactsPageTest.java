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

public class ContactsPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	DealsPage dealspage;
	
	String sheetName="Contacts";


	public ContactsPageTest() throws IOException {
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
		contactspage = homepage.clickonContactsLink();
		 
	}
	
	
	@Test(priority=1)
	public void verifyContactsPageLabel()
	{
		Assert.assertTrue(contactspage.verifyContactsLabel());
	}
	
	@Test(priority=2)
	public void selectContactsTest() 
	{
		contactspage.selectContactsByName("jay patel");
	}
	
	/*@Test(priority=3)
	public void selectMultipleContactsTest() 
	{
		contactspage.selectContactsByName("jay patel");
		contactspage.selectContactsByName("Kruti Patel");
	}*/
	
	@DataProvider
	public Object[][] getTestData() 
	{
		Object data [][]= TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=3, dataProvider="getTestData")
	public void validatecreateNewContact(String title, String firstName , String lastname, String nickname) throws IOException
	{
		homepage.clickOnNewContactLink();
		//contactspage.createNewContact("Mr.", "Nim", "Desai", "car");
		contactspage.createNewContact(title, firstName, lastname, nickname);
	}
	
	
	
	@AfterMethod
	public void teardown() 
	{
		driver.quit();
	}
	

}
