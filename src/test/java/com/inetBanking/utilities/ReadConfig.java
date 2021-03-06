package com.inetBanking.utilities;


import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {
		File src= new File("./Configuration/config.properties");
		try
		{
			FileInputStream fis= new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public String getApplicationUrl()
	{
		return pro.getProperty("baseUrl");
	}
	
	public String getUsername() {
		return pro.getProperty("username");
	}
	public String getPassword() {
		return pro.getProperty("password");
	}
	public String getChromepath() {
		return pro.getProperty("chromepath");
	}
	public String getIEpath() {
		return pro.getProperty("iedriver");
	}
	
}
