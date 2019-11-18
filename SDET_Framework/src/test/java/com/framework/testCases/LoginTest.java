package com.framework.testCases;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.framework.pageObjects.Login;

import Base.BasePage;

public class LoginTest extends BasePage{
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeTest
	public void set(){
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/myreport.html");
	       
        
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Functional Report");
        
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Automation Tester", "Rahul Arora");
        extent.setSystemInfo("Organization", "Way2Automation");
        extent.setSystemInfo("Build no", "W2A-1234");
	}

	@Test
	public void login(){
		
		test = extent.createTest("login");
		
		PropertyConfigurator.configure("C:\\Users\\trast2\\workspace\\SDET_Framework\\Configurations\\log4j.properties");
		log.info("Login Test Case Started");
		driver.get(baseUrl);
		Login login = new Login(driver);
		login.setUserName(user);
		login.setPassword(pass);
		login.clickLoginBtn();
		System.out.println("Test");
		
		log.info("Ending");
		
	}
	

	@Test
	public void passTest(){
		test = extent.createTest("passTest");
		Assert.assertEquals(true, true);
		
	}
	
	@Test
	public void failTest(){
		
		test = extent.createTest("failTest");
		Assert.assertEquals(false, true);
		
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result){
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL, "Test is Failed "+result.getName());
		}else if(result.getStatus()==ITestResult.SUCCESS){
			test.log(Status.FAIL, "Test is Pass "+result.getName());
		}else if(result.getStatus()==ITestResult.SKIP){
			test.log(Status.FAIL, "Test is Skip "+result.getName());}
	}
	
	@AfterTest
	public void flush(){
		extent.flush();
	}
}
