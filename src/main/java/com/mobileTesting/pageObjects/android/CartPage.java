package com.mobileTesting.pageObjects.android;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mobileTesting.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions {
	
AndroidDriver driver;
//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	public List<WebElement> productList;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
	public WebElement toolbarTitle;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	public WebElement totalAmount;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	public WebElement terms;
	
	@AndroidFindBy(id="android:id/button1")
	public WebElement acceptButton;
	
	@AndroidFindBy(className="android.widget.CheckBox")
	public WebElement checkBox;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	public WebElement proceed;
	
	
	
//	driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	
	public List<WebElement> getProductList(){
		return productList;
		}
	
	public double getProductsSum() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));wait.until(ExpectedConditions.attributeContains(toolbarTitle,"text" , "Cart"));
    	int count = productList.size();
    	System.out.println("size="+count);
		double totalSum =0;
    	for(int i =0; i< count; i++)
		{
			String amountString =productList.get(i).getText();
			Double price = getFormattedAmount(amountString);
			totalSum = totalSum + price;  //160.97 + 120 =280.97
		}
    	return totalSum;
	}
	
	public double getTotalAmountDisplayed() {
		return getFormattedAmount(totalAmount.getText());
	}

	public void acceptTermsConditions() {
		longPressAction(terms);
		acceptButton.click();

	}
	public void submitOrder() {
		checkBox.click();
		proceed.click();
	}
}