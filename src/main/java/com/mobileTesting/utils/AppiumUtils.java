package com.mobileTesting.utils;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumUtils {
	
	public AppiumDriverLocalService service;
	public AppiumDriverLocalService startAppiumServer(String ipAddress,int port ) {
		service=new AppiumServiceBuilder()
				.withAppiumJS(new File("C://Users//offic//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress(ipAddress).usingPort(port).build();
		service.start();
		return service;
		
		
	}	
	
	public Double getFormattedAmount(String amount)
	{
		Double price = Double.parseDouble(amount.substring(1));
		return price;	
	}
	public void waitForElementToAppear(WebElement ele,AppiumDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains((ele), "text","cart"));
	}

	public List<HashMap<String,String>> getJsonData(String jsonFilepath) throws IOException
	{
	String jsonContent= FileUtils.readFileToString(new File(jsonFilepath));
	ObjectMapper mapper=new ObjectMapper();
	List<HashMap<String,String>> data = mapper.readValue(jsonContent,new TypeReference<List<HashMap<String,String>>>() {
	});
	return data;	
		}	
	public String getScreenShot(String testCaseName,AppiumDriver driver) throws IOException {
		File source=driver.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"//reports"+testCaseName+".png";
	    FileUtils.copyFile(source, new File(destinationFile));
	return destinationFile;
	
	}
}
