package com.banking.testCases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageObjects.AddCustomerPage;
import com.banking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(Password);
		logger.info("Password is provided");
		lp.clickLogin();
		driver.manage().window().maximize();
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		Thread.sleep(3000);
		addcust.clickAddNewUser();

		logger.info("Providing a customer details.....");
		driver.findElement(By.id("dismiss-button")).click();
		Thread.sleep(10000);

		addcust.custName("janvi");
		addcust.custGender("female");
		addcust.custdob("03", "15", "1996");
		Thread.sleep(3000);
		addcust.custAddress("INDIA");
		addcust.custcity("BVN");
		addcust.custcity("GJ");
		addcust.custpinno("541009");
		addcust.custtelephone("8754123657");
		String email = randomeString() + "@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdety");
		addcust.custsubmit();

		Thread.sleep(3000);
		logger.info("validation is started");
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (res == true) {
			Assert.assertTrue(true);
			logger.info("test case passed...");
		} else

			logger.info("test case failed...");
		captureScreen(driver, "addNewCustomer");
		Assert.assertTrue(false);

	}

}