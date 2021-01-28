package com.techarch.ExtentReportDemo1;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtendReport1 {

	public static void main(String[] args) {
	String dateformat = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
	ExtentReports extent = new ExtentReports();
	
	String filepath = System.getProperty("user.dir")+"//Reports//FirstReports.html";
	
	ExtentHtmlReporter report = new ExtentHtmlReporter(filepath);
	
	extent.attachReporter(report);
	
	ExtentTest test = extent.createTest("Login_Tc01");
	test.info("Entered User Name");
	test.info("Entered Password");
	test.log(Status.FAIL, "Login_Tc01 Passed");
	System.out.println("Test case completed ,Status : PASSED");
	
	ExtentTest test2 = extent.createTest("Login_Tc02");
	test.info("Home Page");
	test.log(Status.INFO, "Home Page Loaded");
	test.info("Home Page");
	test.log(Status.FAIL, "Login_Tc02 Failed");
	System.out.println("Test case completed ,Status : FAILED");
	extent.flush();
	
	}

}
