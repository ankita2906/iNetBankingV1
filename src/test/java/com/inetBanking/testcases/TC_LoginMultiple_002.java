package com.inetBanking.testcases;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.Screenshot;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginMultiple_002 extends BaseClass{

		

	@Test(dataProvider="LoginData")
	public void loginMultiple(String user, String pwd) throws InterruptedException
	{
		
		driver.get(baseUrl);
		logger.info("Opening up: "+baseUrl);
		LoginPage loginpage= new LoginPage(driver);
		logger.info("Trying to log in user with user ID: "+user);
		logger.info(pwd);
		loginpage.setUserName(user);
		loginpage.setPassword(pwd);
		logger.info("Password entered");
		loginpage.clickSubmit();
		Thread.sleep(500);
		if(isAlertPresent()) //fail scenario
		{
			Screenshot.screenShot(driver, "l.oginMultiple");
			driver.switchTo().alert().accept(); //accept the alert
			driver.switchTo().defaultContent(); //will focus on the main page
			logger.warn("Test case: TC_LoginMultiple_002 for userID: "+user+" Status: FAILED");
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Test case: TC_LoginMultiple_002 for userID: "+user+" Status: PASSED");
			loginpage.clickLogout();
			driver.switchTo().alert().accept(); //will close log out alert
			driver.switchTo().defaultContent(); //focus on login browser
			
		}
		
		
	}
	
	public boolean isAlertPresent() {
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(Exception ex)
		{			
		}
		return false;
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path= System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/credentials.xlsx";
		int rowNum= XLUtils.getRowCount(path, "Sheet1");
		logger.info("Number of users: "+rowNum);
		int colNum= XLUtils.getCellCount(path, "Sheet1", 1);
		logger.info(colNum);
		String [][]data = new String[rowNum][colNum];
		for(int i=1;i<rowNum;i++)
		{
	
			for(int j=0;j<colNum;j++)
				{System.out.println("Element: "+XLUtils.getCellData(path, "Sheet1", rowNum, colNum));
				data[i-1][j]= XLUtils.getCellData(path, "Sheet1", i, j);}
		
		}
		
		return data;
	}
}
