package com.mobileTesting;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mobileTesting.TestUtils.AndroidBaseTest;
import com.mobileTesting.TestUtils.BaseTest;
import com.mobileTesting.pageObjects.android.CartPage;
import com.mobileTesting.pageObjects.android.FormPage;
import com.mobileTesting.pageObjects.android.ProductCatalouge;

import org.json.JSONObject;

public class eCommerce_tc_4_Hybrid extends AndroidBaseTest{



	
	
	@Test(dataProvider="getData")
	public void FillForm(HashMap<String,String> input) throws InterruptedException
	{
  		formPage.setNameField(input.get("name"));
		formPage.setGender(input.get("gender"));
		formPage.setCountrySelection(input.get("country"));
		
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
			
	}	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"//src//test//java//com//mobileTesting//testData//form.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};		
	}
	
	@BeforeMethod
	public void preSetup() {
		formPage.setActivity();
	}
	
	
}
