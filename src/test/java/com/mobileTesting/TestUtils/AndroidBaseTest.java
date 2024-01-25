package com.mobileTesting.TestUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import com.mobileTesting.pageObjects.android.FormPage;
import com.mobileTesting.utils.AppiumUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;


public class AndroidBaseTest extends AppiumUtils {
	    public AndroidDriver driver;
		public AppiumDriverLocalService service;
	    public FormPage formPage;
	    

		@BeforeClass
		public void configureAppium() throws IOException {
			Properties prop=new Properties();
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//data.properties");
			prop.load(fis);
			String ipAddress=prop.getProperty("ipAddress");
			String port=prop.getProperty("port");
			String androidDeviceName=prop.getProperty("androidDeviceName");
			
			
			service=startAppiumServer(ipAddress, Integer.parseInt(port));
			UiAutomator2Options options = new UiAutomator2Options();
			options.setDeviceName(androidDeviceName);
		    options.setApp(System.getProperty("user.dir")+"src//test//resources//ApiDemos-debug.apk");
			options.setApp(System.getProperty("user.dir")+"//src//test//resources//General-Store.apk");
		    driver=new AndroidDriver(service.getUrl(),options);
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		    this.formPage=new  FormPage(driver);
		}
		
		@AfterClass
		public void tearDown() {
			driver.quit();
			service.stop();
		}
}
