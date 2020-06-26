package com.tyss.projectframeworks.scripts;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tyss.projectframeworks.init.Iconstants;
import com.tyss.projectframeworks.lib.Baselib;
import com.tyss.projectframeworks.lib.ExcelLib;
import com.tyss.projectframeworks.lib.GenericLib;
import com.tyss.projectframeworks.pages.AddtoCart;
import com.tyss.projectframeworks.pages.BookPage;
import com.tyss.projectframeworks.pages.Homepage;
import com.tyss.projectframeworks.pages.MyCartPage;
import com.tyss.projectframeworks.pages.SignInPage;
@Listeners(com.tyss.projectframeworks.listners.MyListners.class)
public class LogiTest extends Baselib {
	
	 
	
	@Test
	public void tc_02() throws InterruptedException
	{
		Homepage hp = new Homepage(driver);
		Assert.assertEquals(hp.getHomePage(), ExcelLib.getData("Sheet1", 1, 1, Iconstants.expectedexcelPath));
		hp.myAccoutClick();
		Thread.sleep(5000);
		SignInPage sip = new SignInPage(driver);
		Assert.assertEquals(sip.getSignInPage(), ExcelLib.getData("Sheet1", 1, 2, Iconstants.expectedexcelPath));
	String un = ExcelLib.getData("Sheet1",1,1,Iconstants.DataexcelPath);
	String pw = ExcelLib.getData("Sheet1",1,2,Iconstants.DataexcelPath);
	sip.doLogin(un, pw);
	MyCartPage mcp = new MyCartPage(driver);
	Assert.assertEquals(mcp.getWelcomeName(), ExcelLib.getData("Sheet1", 1, 3, Iconstants.expectedexcelPath));
	Thread.sleep(5000);
	BookPage bp = new BookPage(driver);
	Thread.sleep(5000);
	bp.BooksClick();
	Thread.sleep(5000);
	bp.Book1Click();
	Thread.sleep(5000);
	AddtoCart atc = new AddtoCart(driver);
	Assert.assertEquals(atc.getaddCart(), ExcelLib.getData("Sheet1", 1, 4, Iconstants.expectedexcelPath));
	atc.addCart();
	Thread.sleep(5000);
	GenericLib.handleAlert(driver);
	Thread.sleep(5000);
	}
	
	
}
