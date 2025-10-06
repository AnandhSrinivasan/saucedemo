package com.saucedemo.utils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reports {

	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extentReports;
	public static ExtentTest extentTests;
	
	@BeforeSuite(alwaysRun = true)
	public static void startReport() {
		try {
			sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"Saucedemo.html");
			sparkReporter.config().setReportName("Saucedemo"); 
			sparkReporter.config().setDocumentTitle("Web Auto Report");
			sparkReporter.config().setTheme(Theme.DARK);
			sparkReporter.config().setTheme(Theme.STANDARD);
			extentReports = new ExtentReports();
			extentReports.attachReporter(sparkReporter);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void setTCDesc(String testcaseName) {
		try {
			extentTests=extentReports.createTest(testcaseName);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	public static void reportStep(String status, String desc) {
		try {
			if(status.equalsIgnoreCase("PASS")) {
				extentTests.log(Status.PASS, desc);
			}
			else if (status.equalsIgnoreCase("FAIL")) {
				extentTests.log(Status.FAIL, desc);
			}
			else if (status.equalsIgnoreCase("SKIP")) {
				extentTests.log(Status.SKIP, desc);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterSuite(alwaysRun = true)
	public void endReport(){
		try {
			extentReports.flush();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
