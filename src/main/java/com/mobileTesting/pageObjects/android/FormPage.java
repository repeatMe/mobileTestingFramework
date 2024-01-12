package com.mobileTesting.pageObjects.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.mobileTesting.utils.AndroidActions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
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
	
	@AndroidBy(xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement femaleOption;
	
	@AndroidBy(xpath="//android.widget.RadioButton[@text='Male']")
	private WebElement maleOption;
	
	@AndroidBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement countryDropdwnButton;
	
	@AndroidBy(id="android:id/text1")
	private WebElement countrySelection;
	
	@AndroidBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;
		
	//driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
	
	public void setNameField(String name) {
		nameField.sendKeys("Abhishek");
		driver.hideKeyboard();
		
	}
	public void setGender(String gender) {
		if(gender.contains("female")) 
			femaleOption.click();
		else 
			maleOption.click();
		
	}
	
	public void setCountrySelection(String countryName) {
		countrySelection.click();
		scrollToText(countryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
		
	}
	
	public void submitForm() {
		shopButton.click();
	}
	
	
	
	
	
}
