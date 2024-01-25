package com.mobileTesting;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;
import com.mobileTesting.TestUtils.BaseTest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;


public class eCommerce_tc_2 extends BaseTest{

	@BeforeMethod
	public void preSetup() {
		//this line will help to come back to the home page after every test run.
		//Activity activity=new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity");
		//driver.currentActivity();
		driver.executeScript("mobile: startActivity", ImmutableMap.of("intent","com.androidsample.generalstore/com.androidsample.generalstore.MainActivity"));
	}
	
	
	@Test
	public void FillForm_ErrorValidation() throws InterruptedException
	{
	
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();	
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastMessage,"Please enter your name");	
	}
	
	
	@Test
	public void FillFormPositiveFlow() throws InterruptedException
	{
	    driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Abhishek");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();		
		Assert.assertTrue(driver.findElements(By.xpath("(//android.widget.Toast)[1]")).size()<1);

		
	}
}
