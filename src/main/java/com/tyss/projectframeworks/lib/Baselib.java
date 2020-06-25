package com.tyss.projectframeworks.lib;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.seleniumhq.jetty9.servlet.ServletContextHandler.Context;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class Baselib {
	static{
		System.setProperty(GenericLib.getPropData("browserkey"), GenericLib.getPropData("browservalue"));
	}
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp(ITestContext contex) {
		if(GenericLib.getPropData("browsername").equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options); 
			}
		
		else if(GenericLib.getPropData("browsername").equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addPreference("dom.webnotifications.enabled", false);
			driver = new FirefoxDriver(options); 
			}
		else {
			Assert.fail("browser name not valid");
		}
		contex.setAttribute("driver",driver);	
		Reporter.log("Browser launched successfully ");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(GenericLib.getPropData("url"));
		Reporter.log("Application loaded ");
			}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
