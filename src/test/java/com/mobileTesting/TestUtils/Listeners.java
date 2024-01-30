package com.mobileTesting.TestUtils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.mobileTesting.utils.AppiumUtils;

import io.appium.java_client.AppiumDriver;

public class Listeners extends AppiumUtils implements ITestListener {
	ExtentReports extent=ExtentReporterNG.getReporterObject();
	ExtentTest test;
	AppiumDriver driver;
	
	@Override
	 public  void onTestStart(ITestResult result) {
		    test=extent.createTest(result.getMethod().getMethodName());
		    
		  }

	
		 public void onTestSuccess(ITestResult result) {
		   test.log(Status.PASS, "Test Passed");
		  }

		 public void onTestFailure(ITestResult result) {
		    test.fail(result.getThrowable());
		    
		    
		  //by using  this line ucan get any filed present in ur test class
		      
				try {
					driver =(AppiumDriver) result.getTestClass().getRealClass().getField("driver")
							.get(result.getInstance());
				} catch (Exception e) {
					e.printStackTrace();
				}
			   
		    try {
				test.addScreenCaptureFromPath(getScreenShot(result.getMethod().getMethodName(),driver ));
			} catch (IOException e) {
				e.printStackTrace();
			}
		 }	 
		 
		 public void onTestSkipped(ITestResult result) {
		    // not implemented
		  }

		 
		 public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		    // not implemented
		  }

		
		 public void onTestFailedWithTimeout(ITestResult result) {
		    onTestFailure(result);
		  }

		 
		 public void onStart(ITestContext context) {
		    // not implemented
		  }

		 
		 public void onFinish(ITestContext context) {
	       extent.flush();
		  }

}
