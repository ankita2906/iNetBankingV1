package com.inetBanking.testcases;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.pageObjects.NewCustomer;
import com.inetBanking.utilities.RandomDataGen;
import com.inetBanking.utilities.Screenshot;

public class TC_CreateNewCustomer_003 extends BaseClass{
	@Test
	public void addNewCustomer() throws InterruptedException {
		
		driver.get(baseUrl);
		LoginPage loginpage= new LoginPage(driver);
		
		loginpage.setUserName(username);
		loginpage.setPassword(password);
		loginpage.clickSubmit();
		
		  WebDriverWait w = new WebDriverWait(driver,5);
	      // presenceOfElementLocated condition
	      w.until(ExpectedConditions.titleContains("HomePage"));
	      
	      NewCustomer customerpage= new NewCustomer(driver);
	      customerpage.clickAddNewCustomer();
	      
	      customerpage.custName("ankita");
	      customerpage.custgender();
	      customerpage.custdob("06", "29", "96");
	      customerpage.custaddress("xyz street");
	      customerpage.custcity("Guwahati");
	      customerpage.custstate("Assam");
	      customerpage.custpinno("781007");
	      customerpage.custtelephoneno(RandomDataGen.randomPhoneNumberGen());
	      String email= RandomDataGen.randomStringGen()+"@gmail.com";
	      customerpage.custemailid(email);
	      customerpage.custpassword("password123");
	      Thread.sleep(10000);
	      customerpage.custsubmit();
	      
	      if(driver.getPageSource().contains("Customer Registered Successfully"))//get html source and check if this line is there
	      {
	    	  Assert.assertTrue(true);
	      }
	      else
	      {
	    	  Screenshot.screenShot(driver, "addNewCustomer");
	    	  Assert.assertTrue(false);
	      }
	      
	      
	      
	      
	      
	}
	

}
