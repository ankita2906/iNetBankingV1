package com.inetBanking.testcases;

import org.junit.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.google.common.base.Verify;
import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.Screenshot;

public class TC_Login_001 extends BaseClass{
	
	@Test
	public void loginTest()
	{
		driver.get(baseUrl);
		logger.info("Opening up: "+baseUrl);
		LoginPage lp=new LoginPage(driver);
		logger.info("Trying to log in user with user ID: "+username);
		lp.setUserName(username);
		lp.setPassword(password);
		logger.info("Password entered");
		lp.clickSubmit();
		if(driver.getTitle().contains("HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Test case: TC_LOGIN_001 Status: PASSED");

		}
		else
		{
			Screenshot.screenShot(driver, "loginTest");
			logger.info("Test case: TC_LOGIN_001 Status: FAILED");
			Assert.assertTrue(false);
			
		}
		
	}

}
