package com.mobileTesting.pageObjects.android;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;
import com.mobileTesting.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions{
    AndroidDriver driver;
    
    public FormPage(AndroidDriver driver){
	    super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
 }
	
   //driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rahul Shetty");
	
    @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
    @AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement femaleOption;
	
    @AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
	private WebElement maleOption;
	
    @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement countryDropdwnButton;
	
	@AndroidFindBy(id = "android:id/text1")
	private WebElement countrySelection;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;
		
	
	public void setNameField(String name) throws InterruptedException {
		Thread.sleep(2000);
		nameField.sendKeys(name);
        driver.hideKeyboard();	
	}
	
	public void setGender(String gender) {
		if(gender.contains(gender)) 
			femaleOption.click();
		else 
			maleOption.click();			
	}
	
	public void setCountrySelection(String countryName) {
		countrySelection.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scrollToText(countryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();	
		 
	}
	
	
	public ProductCatalouge submitForm() {
		shopButton.click();	
		return new ProductCatalouge(driver);
	}	
	
	public void setActivity() {
		driver.executeScript("mobile: startActivity", ImmutableMap.of("intent","com.androidsample.generalstore/com.androidsample.generalstore.MainActivity"));
	}
	
}
