package com.tyss.projectframeworks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.projectframeworks.lib.GenericLib;

public class Homepage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//a[contains(.,'My Account')]")
	private WebElement myAccount;
	
	@FindBy(name = "product")
	private WebElement searchBox;
	
	@FindBy(xpath = "//button[@name='search']")
	private WebElement searchEnter;
	
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}

	
	public void myAccoutClick()
	{
		GenericLib.clickElement(driver, myAccount, "Account Button");
	}
	
	public void searchEnterTextandsearchClick(String searchKey) throws InterruptedException
	{
		GenericLib.enterText(driver, searchBox, searchKey, "SearchBox");
		Thread.sleep(5000);
		GenericLib.clickElement(driver, searchEnter, "search Btn");
	}

	public String getHomePage() {

		return driver.getTitle();
	}

}
