package com.tyss.projectframeworks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.projectframeworks.lib.GenericLib;

public class BookPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//div[@id='mc-horizontal-menu-collapse']/div/ul/li[2]/a")
	private WebElement Booksbtn;
	
	@FindBy(xpath = "//div[@id='grid-container']/div/div/div[1]/div/div/div[2]/h3/a")
	private WebElement Book1;
	
	public  BookPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	public void BooksClick() {
		GenericLib.clickElement(driver, Booksbtn, "books click");
	}
	
	public void Book1Click() {
		GenericLib.clickElement(driver, Book1, "books click");
	}
	
	
}
