package com.truecaller.tests;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_QATestAppLogin_001 extends BaseClass {

	@Test
	public void login() throws MalformedURLException, InterruptedException {

		try {

			String regdEmailValue = "helloworld@gmail.com";
			String regdPwdValue = "testing1234";

			//Capabilities();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			// Registration page

			WebElement regdEmail = driver.findElement(By.id("com.qatestapp:id/emailTextField1"));
			regdEmail.sendKeys(regdEmailValue);
			WebElement regdPwd = driver.findElement(By.id("com.qatestapp:id/passwordTextField"));
			regdPwd.sendKeys(regdPwdValue);
			WebElement regdLoginBtn = driver.findElement(By.id("com.qatestapp:id/LoginButton"));
			regdLoginBtn.click();

			// login page
			String name = "Gayatri Nayak";
			String email = "tester@truecaller.com";
			String phnumber = "0565678789";

			WebElement loginName = driver
					.findElement(By.xpath("//android.widget.EditText[@resource-id='com.qatestapp:id/nameTextField']"));
			loginName.sendKeys(name);
			WebElement loginEmail = driver.findElement(By.id("com.qatestapp:id/emailTextField"));
			loginEmail.sendKeys(email);
			WebElement loginPhno = driver.findElement(By.id("com.qatestapp:id/phoneNumberTextField"));
			loginPhno.sendKeys(phnumber);
			WebElement subscribe = driver.findElement(By.className("android.widget.CheckBox"));
			subscribe.click();
			WebElement submit = driver.findElement(By.id("com.qatestapp:id/button2"));
			submit.click();
			

			WebElement msg = driver.findElement(By.id("com.qatestapp:id/landingText"));

			String landingMsg = msg.getText();
			String expected = "My name is " + name + ".\r\n" + "You can reach me by calling me on " + phnumber + ".\r\n"
					+ "Also, mail me at " + email + ".";

			System.out.println(landingMsg);

			Assert.assertEquals(landingMsg, expected);
		} catch (Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();

		}

	}

}
