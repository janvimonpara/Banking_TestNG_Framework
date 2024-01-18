package com.banking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.pageObjects.LoginPage;
import com.banking.utilities.XLUtils;


public class TC_LoginDDT_002 extends BaseClass {
	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String uname, String pwd) throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(uname);
		logger.info("user name is provided");
		lp.setPassword(pwd);
		logger.info("password is provided");
		lp.clickLogin();
		Thread.sleep(3000);

		if (isAleartPresent() == true) {
			driver.switchTo().alert().accept();// close the error alert
			driver.switchTo().defaultContent();// get back to home page/default page means focus on login page
			Assert.assertTrue(false);
			logger.warn("login failed");

		} else
			Assert.assertTrue(true);
		logger.info("login passed");
		lp.clickLogout();
		Thread.sleep(3000);
		driver.switchTo().alert().accept(); // close the logout alert
		driver.switchTo().defaultContent();// get back to home page/default page means focus on login page

	}

	public boolean isAleartPresent() // user defined method created to check alert is present or not
	{
		try {

			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	@DataProvider(name = "LoginData") // taking data from excel file
	String[][] getData() throws IOException {

		String path = System.getProperty("user.dir") + "/src/test/java/com/testing/testData/LoginData.xlsx";

		int rownum = XLUtils.getRowCount(path, "sheet1");
		int colcount = XLUtils.getCellCount(path, "sheet1", 1);

		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {

			for (int j = 0; j < colcount; j++) {

				logindata[i - 1][j] = XLUtils.getCellData(path, "sheet1", i, j); // 1 0

			}
		}
		return logindata;
	}

}
