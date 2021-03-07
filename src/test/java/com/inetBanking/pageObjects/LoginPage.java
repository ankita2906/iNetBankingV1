package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
	
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="input[name=uid]")
	WebElement userId;
	
	@FindBy(name="password")
	WebElement userpass;
	
	@FindBy(name="btnLogin")
	WebElement login;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	WebElement logout;
	
	public void setUserName(String username) { 
		userId.sendKeys(username);
	}
	
	public void setPassword(String password) { 
		userpass.sendKeys(password);
	}
	
	public void clickSubmit() { 
		login.click();
	}

	public void clickLogout() {

		Actions actions = new Actions(driver);
		actions.moveToElement(logout);
		actions.perform();
		logout.click();
		
	}
}
