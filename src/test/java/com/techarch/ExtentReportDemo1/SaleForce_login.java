package com.techarch.ExtentReportDemo1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.testng.annotations.BeforeTest;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SaleForce_login {

	public static WebDriver driver;
	public static ExtentHtmlReporter report;
	public static ExtentReports extent;
	static String dateformat = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
	
	@BeforeTest
 static void launchBrowser() throws Exception{
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		extent = new ExtentReports();
		report = new ExtentHtmlReporter(System.getProperty("user.dir")+"//Reports//"+dateformat+"SFDCReport.html");
		extent.attachReporter(report);
		
		
	}
	
	
	
	@Test
public static void loginToSales() throws Exception {
	
	ExtentTest test = extent.createTest("Login To sales");
	driver.get("https://login.salesforce.com");
	test.log(Status.INFO, "Login Page is launched");
	WebElement userN = driver.findElement(By.xpath("//input[@name='username']"));

	userN.clear();
	userN.sendKeys("jyotitesting03-t64c@force.com");
	test.info("Entered User name");
	WebElement passW = driver.findElement(By.xpath("//input[@type='password']"));
	passW.sendKeys("Testing123");
	test.info("Entered password");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@name='Login']")).click();
	if(driver.getTitle().equalsIgnoreCase("https://rokuinc3.lightning.force.com/one/one.app")){
		test.log(Status.PASS,"login to sales");
		//Assert.assertEquals(driver.findElement(By.xpath(
				//"//body/div[@id='contentWrapper']/div[@id='AppBodyHeader']/div[1]/div[1]/nav[1]/ul[1]/li[1]/a[1]")).isDisplayed(),true);
	}else
		test.log(Status.FAIL, "Login to sales was failed");
		//Assert.fail("Login to sales");



}
	@AfterClass
	public void closereport() {
		extent.flush();
		driver.close();
	}
	
	
	public static void waitExplicitly(int iSeconds, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver,iSeconds);
		wait.ignoring(NoSuchElementException.class, ElementNotVisibleException.class);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void quitBrowser() {
		driver.quit();
		
}
	
}
			
			
			
			
			
			
