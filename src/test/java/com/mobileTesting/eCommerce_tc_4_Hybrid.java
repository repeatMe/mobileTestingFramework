package com.mobileTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mobileTesting.pageObjects.android.CartPage;
import com.mobileTesting.pageObjects.android.ProductCatalouge;

public class eCommerce_tc_4_Hybrid extends BaseTest{

	@Test
	public void FillForm() throws InterruptedException 
	{
		
  		formPage.setNameField("Abhishek");
		formPage.setGender("female");
		formPage.setCountrySelection("Argentina");
		ProductCatalouge productCatalouge=formPage.submitForm();
		
		//ProductCatalouge productCatalouge=new ProductCatalouge(driver);
		productCatalouge.addItemCartByIndex(0);
		productCatalouge.addItemCartByIndex(0);
		CartPage cartpage=productCatalouge.goToCartPage();
		double totalSum=cartpage.getProductsSum();
		double displayFormattedSum=cartpage.getTotalAmountDisplayed();
		Assert.assertEquals(totalSum, displayFormattedSum);
		cartpage.acceptTermsConditions();
		cartpage.submitOrder();
			
//	Thread.sleep(6000);
//	Set<String> contexts =driver.getContextHandles();
//	for(String contextName :contexts)
//	{
//		System.out.println(contextName);
//	}

//	driver.context("WEBVIEW_com.androidsample.generalstore");//chrome driver
//	driver.findElement(By.name("q")).sendKeys("rahul shetty academy");
//	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//	driver.pressKey(new KeyEvent(AndroidKey.BACK));
//	driver.context("NATIVE_APP");
//	

//	//Hybrid - Google page->
			
		
	}
	
	
}
