package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	 public static WebDriver driver;
	 public static Properties prop;
	 public static EventFiringWebDriver edriver;
	 public static WebDriverEventListener eventListner;
	 
	
	public TestBase() throws IOException {
		
		FileInputStream f = new FileInputStream("C:\\Selenium_Workspace\\Finalmavenproject\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		prop = new Properties();
		prop.load(f);
		
	}
	
	public static void initialization() throws IOException {
		String browser = prop.getProperty("browser");
		//String browser="Chrome"; //Firefox,Chrome,Safari // read data from Excel,Properties.
		
		
		if(browser.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Seleniumjars\\geckodriver.exe");
			driver =new FirefoxDriver(); // open firefox
	       
		}
		else if(browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Seleniumjars\\chromedriver.exe");
			driver =new ChromeDriver(); // open chrome
	    }
		/*else 
		{
			System.setProperty("webdriver.safari.driver", "C:\\Seleniumjars\\safaridriver.exe");
			 driver=new SafariDriver(); // open safari
		}*/
		
		edriver = new EventFiringWebDriver(driver);
		eventListner = new WebEventListener();
		edriver.register(eventListner);
		driver =edriver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_Load_TimeOut,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicitly_Wait, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
	

}
