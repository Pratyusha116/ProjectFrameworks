package com.tyss.projectframeworks.scripts;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tyss.projectframeworks.init.Iconstants;
import com.tyss.projectframeworks.lib.Baselib;
import com.tyss.projectframeworks.lib.ExcelLib;
import com.tyss.projectframeworks.pages.Homepage;
import com.tyss.projectframeworks.pages.MyCartPage;
import com.tyss.projectframeworks.pages.SignInPage;
@Listeners(com.tyss.projectframeworks.listners.MyListners.class)
public class LogiTest extends Baselib {
	
	 
	@Test(enabled = false)
	public void login() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		
		driver.findElement(By.xpath("//i[@class=\"icon fa fa-user\"]")).click();
		
		FileInputStream fin =new FileInputStream(Iconstants.DataexcelPath);
		Workbook wb = WorkbookFactory.create(fin);
		Sheet sh = wb.getSheet("Sheet1");
		
		String username = sh.getRow(1).getCell(1).getStringCellValue();
		String pass = sh.getRow(1).getCell(2).getStringCellValue();
		
		
		driver.findElement(By.name("email")).sendKeys(username);	
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys(pass,Keys.ENTER);
		Thread.sleep(5000);
		
		}
	
	@Test
	public void tc_02() throws InterruptedException
	{
		Homepage hp = new Homepage(driver);
		Assert.assertEquals(hp.getHomePage(), ExcelLib.getData("Sheet1", 1, 1, Iconstants.expectedexcelPath));
		//System.out.println(hp.getHomePage());
		hp.myAccoutClick();
		Thread.sleep(5000);
		SignInPage sip = new SignInPage(driver);
		//System.out.println(sip.getSignInPage());
		Assert.assertEquals(sip.getSignInPage(), ExcelLib.getData("Sheet1", 1, 2, Iconstants.expectedexcelPath));
	String un = ExcelLib.getData("Sheet1",1,1,Iconstants.DataexcelPath);
	String pw = ExcelLib.getData("Sheet1",1,2,Iconstants.DataexcelPath);
	sip.doLogin(un, pw);
	MyCartPage mcp = new MyCartPage(driver);
	//System.out.println(mcp.getWelcomeName());
	Assert.assertEquals(sip.getSignInPage(), ExcelLib.getData("Sheet1", 1, 2, Iconstants.expectedexcelPath));
	Thread.sleep(5000);
	}
	
	@Test(enabled = false)
	public void tc_03() throws InterruptedException {
		Homepage hp = new Homepage(driver);
		hp.searchEnterTextandsearchClick("TV");
		
			System.out.println(hp.getHomePage());

		
		Thread.sleep(5000);
	}
}
