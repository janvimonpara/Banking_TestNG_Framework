package com.banking.testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException {

		logger.info("URL is Opened");

		LoginPage lp = new LoginPage(driver);

		lp.setUserName(username);
		logger.info("Entered UserName");

		lp.setPassword(Password);
		logger.info("Entered Password");

		lp.clickLogin();

		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		// wait.until(ExpectedConditions.alertIsPresent());

		if (wait.until(ExpectedConditions.alertIsPresent()) != null) {
			logger.info("login fail");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		} else {
			logger.info("login successfully");
		}

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {

			Assert.assertTrue(true);
			logger.info("Login test passed");
		} else {

			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");

		}

	}

}
