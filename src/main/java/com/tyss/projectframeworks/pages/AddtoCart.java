package com.tyss.projectframeworks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.projectframeworks.lib.GenericLib;

public class AddtoCart {
	
	WebDriver driver;
	
	@FindBy(xpath= "//i[@class='fa fa-shopping-cart inner-right-vs']")
	private WebElement AddCart;
	
public AddtoCart(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
			}

public void addCart() {
	GenericLib.clickElement(driver, AddCart, "Addcart click");
}

public String getaddCart() {
	return driver.getTitle();
}

}
