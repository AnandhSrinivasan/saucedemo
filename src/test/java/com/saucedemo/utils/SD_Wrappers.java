package com.saucedemo.utils;

import org.openqa.selenium.support.PageFactory;

import com.saucedemo.pages.Items_page;

public class SD_Wrappers extends Se_Wrappers{

	public void itemspageWrappper(String username, String pword) {
		try {
			Items_page itemspage = PageFactory.initElements(driver, Items_page.class);
			itemspage.enterUsername(username);
			itemspage.enterPassword(pword);
			itemspage.clickLoginbutton();
			screenshot("Login successfully");
			itemspage.clickmenubutton();
			itemspage.clickaddtocartbutton();
			screenshot("view_cart_qty");
			itemspage.clickresetAppstatebutton();
			screenshot("click reset and view_cart_qty");
			itemspage.verifyRemovtext();
			screenshot("view_cart_qty and view Remove Button");
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}

