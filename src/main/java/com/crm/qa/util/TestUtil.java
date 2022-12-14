package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;



public class TestUtil extends TestBase
{
	
	 public TestUtil() throws IOException {
		super();
		
	}

	public static long page_Load_TimeOut =20;
	 public static long Implicitly_Wait= 10;
	 
	 public static String TestDataSheet ="C:\\Selenium_Workspace\\Finalmavenproject\\src\\main\\java\\com\\crm\\qa\\testdata\\FinalMavenTestData.xlsx";
	 
	 static Workbook book;
	 static Sheet sheet;
	 
	 
	 public void switchToFrame()
	 {
		 driver.switchTo().frame("mainpanel");
	 }
	
	 public static Object[][] getTestData(String sheetName)
	 {
		 FileInputStream file=null;
		 try
		 { 
			 file = new FileInputStream(TestDataSheet);
		 }
		 catch(FileNotFoundException e)
		 {
			 e.printStackTrace();
		 }
		 
		 try {
			 book= WorkbookFactory.create(file);
		 }
		 catch(InvalidFormatException e)
		 {
			 e.printStackTrace();
		 }
		 catch(IOException e)
		 {
			 e.printStackTrace();
		 }
		 
		 sheet= book.getSheet(sheetName);
		 Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		 
		 for(int i=0; i< sheet.getLastRowNum();i++) {
			 for(int k=0; k< sheet.getRow(0).getLastCellNum(); k++) 
			 {
				  data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			 }
		 }
		return data;
		 
	 }
	 
	 public static void takeScreenshotAtEndOfTest() throws IOException {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			FileUtils.copyFile(scrFile, new File("currentDir + \"/screenshots/\" + System.currentTimeMillis() + \".png\""));
		}
	

}
