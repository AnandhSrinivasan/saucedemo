package com.saucedemo.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.model.ReportStats;
import com.aventstack.extentreports.util.Assert;
import com.saucedemo.utils.Reports;
import com.saucedemo.utils.SD_Wrappers;
import com.saucedemo.utils.Se_Wrappers;

public class itemspage_Test extends Se_Wrappers{

	Se_Wrappers se = new Se_Wrappers();
	SD_Wrappers sd = new SD_Wrappers();
	
	@Test(priority=1)
	public void bugtest() {
		try {
			Reports.setTCDesc("Bug Found");
			sd.itemspageWrappper("standard_user", "secret_sauce");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Failed to catch the bug");
			Reports.reportStep("FAIL", "Problem while founding the bug");
		}
	}
	
	@AfterMethod
	public void closeBrowser(){
		try{
			driver.	quit();
			Reports.reportStep("PASS", "Browser closed successfully");
		}
		catch(Exception ex){
			System.out.println("Problem in closing the browser");
			Reports.reportStep("FAIL", "Problem in closing the browser");
			ex.printStackTrace();
		}

	}
}
