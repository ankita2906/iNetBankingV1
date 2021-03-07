package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomer {

	WebDriver driver;
	
	public NewCustomer(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	WebElement newCustomer;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement customerName;
	
	@FindBy(xpath="//input[@value='m']")
	WebElement gender;
	
	@FindBy(id="dob")
	WebElement dob;
	
	@FindBy(xpath="//textarea[@name='addr']")
	WebElement address;
	
	@FindBy(xpath = "//input[@name='city']")
	WebElement city;
	
	@FindBy(xpath = "//input[@name='state']")
	WebElement state;
	
	@FindBy(xpath = "//input[@name='pinno']")
	WebElement pin;
	
	@FindBy(xpath = "//input[@name='telephoneno']")
	WebElement phone;
	
	@FindBy(xpath = "//input[@name='emailid']")
	WebElement emailid;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement submit;
	
	public void clickAddNewCustomer() {
		newCustomer.click();
			
	}

	public void custName(String cname) {
		customerName.sendKeys(cname);
		
	}

	public void custgender() {
		gender.click();
	}

	public void custdob(String mm,String dd,String yy) {
		dob.sendKeys(mm);
		dob.sendKeys(dd);
		dob.sendKeys(yy);
		
	}

	public void custaddress(String caddress) {
		address.sendKeys(caddress);
	}

	public void custcity(String ccity) {
		city.sendKeys(ccity);
	}

	public void custstate(String cstate) {
		state.sendKeys(cstate);
	}

	public void custpinno(String cpinno) {
		pin.sendKeys(String.valueOf(cpinno)); //in case pin is passed as number
	}

	public void custtelephoneno(String ctelephoneno) {
		phone.sendKeys(ctelephoneno);
	}

	public void custemailid(String cemailid) {
		emailid.sendKeys(cemailid);
	}

	public void custpassword(String cpassword) {
		password.sendKeys(cpassword);
	}

	public void custsubmit() {
		submit.click();
	}
	
	
}
