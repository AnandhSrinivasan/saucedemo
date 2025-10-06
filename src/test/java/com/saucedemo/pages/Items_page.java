package com.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.saucedemo.utils.Se_Wrappers;

public class Items_page extends Se_Wrappers {

	@FindBy(id = "user-name")
	public WebElement username;
	
	public void enterUsername(String uname) {
		clickElement(username);
		waitforelementExplicitwait(username, 5);
		typeText(username, uname);
	}
	
	@FindBy(id = "password")
	public WebElement pword;
		
	public void enterPassword(String pass) {
	    clickElement(pword);
		waitforelementExplicitwait(pword, 5);
		typeText(pword, pass);
	}
	
	@FindBy(id = "login-button")
	public WebElement login;
	
	public void clickLoginbutton() {
		waitforelementExplicitwait(login, 2);
		clickElement(login);
	}	
		
	@FindBy(id = "react-burger-menu-btn")
	public WebElement menubutton;
		
	public void clickmenubutton() {
		waitforelementExplicitwait(menubutton, 2);
		clickElement(menubutton);	
	}
		
	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	public WebElement addtocart;
			
	public void clickaddtocartbutton() {
		waitforelementExplicitwait(addtocart, 2);
		clickElement(addtocart);		
	}
	
	@FindBy(id = "reset_sidebar_link")
	public WebElement resetAppstate;
			
	public void clickresetAppstatebutton() {
		waitforelementExplicitwait(resetAppstate, 2);
		clickElement(resetAppstate);		
	}
	
	@FindBy(xpath = "//button[text()='Remove']")
	public WebElement remove;
			
	public void verifyRemovtext() {
		getTextFromElement(remove);
	}
}
