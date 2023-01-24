package com.test.testutil;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.test.base.TestBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class WebEventListener extends TestBase implements ITestListener
{
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		test = extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		test.log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		
		test.fail(result.getThrowable());
		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) 
		{
			e.printStackTrace(); 
		}
		
		try {
			getScreenshots(testMethodName,driver);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		extent.flush();
	}
	
}
