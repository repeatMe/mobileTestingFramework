package com.mobileTesting.pageObjects.android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.mobileTesting.utils.AndroidActions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalouge extends AndroidActions{
    AndroidDriver driver;
    public void productCatalouge(AndroidDriver driver) {
    	this.driver=driver;
    }
    
    @AndroidBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
    public List<WebElement> addToCart;
    
    @AndroidBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
    public WebElement cart;
    
    
    public ProductCatalouge(AndroidDriver driver){
	    super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	
 }
	public void addItemCartByIndex(int index) {
		addToCart.get(index).click();
		
	}
	
	public void goToCartPage() throws InterruptedException {
		cart.click();
		Thread.sleep(2000);
	}
	
	
	
}
