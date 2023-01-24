package com.truecaller.tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	static AppiumDriver driver;

	@BeforeTest
	public static AppiumDriver setup() throws MalformedURLException {

		try {
			File f = new File("src/test/java");
			File fs = new File(f, "QATestApp-1.1.apk");

			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "myemulatorrr");
			cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AppiumDriver(url, cap);

			return driver;
		} catch (Exception exp) {
			System.out.println("cause is:" + exp.getCause());
			System.out.println("Message is:" + exp.getMessage());
			exp.printStackTrace();
		}
		return driver;
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
