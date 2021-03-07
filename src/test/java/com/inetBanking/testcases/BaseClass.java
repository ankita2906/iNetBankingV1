package com.inetBanking.testcases;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import com.inetBanking.utilities.ReadConfig;


public class BaseClass {
	ReadConfig readConfig = new ReadConfig();
	public String baseUrl= readConfig.getApplicationUrl();
	public String username= readConfig.getUsername();
	public String password= readConfig.getPassword();
	public static WebDriver driver;
	public static Logger logger; //becuase this will be used within multiple methods in each testcase so it 
	//should not be local to before class method only
	/*
	 * System.getProperty("user.dir") -> project home directory
	 */
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) //parameter to record the browser variable
	{
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", readConfig.getChromepath());
		driver= new ChromeDriver();
		}
		if(br.equals("ie")){
			
			System.setProperty("webdriver.ie.driver", readConfig.getIEpath());
			  
			driver= new InternetExplorerDriver();
		}
		logger= Logger.getLogger("ebanking"); //just name of project
		PropertyConfigurator.configure("log4j.properties");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	

	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
