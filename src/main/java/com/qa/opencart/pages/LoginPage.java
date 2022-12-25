package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.util.Constant;
import com.qa.opencart.util.ElementUtil;

public class Loginpage {
	//1. declare private driver.
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//2. create loginpage constructor to initialize driver
	public Loginpage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	//3. By locators
	private By emailID = By.id("input-email");
	private By password = By.id("input-password");
	private By loginbtn = By.xpath("//input[@value ='Login']");
	private By registerlink = By.xpath("//a[@class='list-group-item'][2]");
	private By forgetPwdLink = By.linkText("Forgotten Password");
	private By header = By.cssSelector("div#logo");
	
	
	//4. page actions
	public boolean getLoginPageTitle() {
		return eleUtil.doGetTitle(Constant.Login_PAGE_TITLE, Constant.DEFAULT_TIME_OUT);
	}
	
	public String getPageHeaderText() {
		return eleUtil.doGetText1(header);
	}
	
	public boolean isForgetPwdLinkExists() {
		return eleUtil.doIsDisplayed(forgetPwdLink);
	}
	
	public boolean isRegisterLinkExists() {
		return eleUtil.doIsDisplayed(registerlink);
		
	}
	
	public Accountspage doLogin(String un, String pwd) {
	System.out.println("login with:"+ un + " : " + pwd);
	eleUtil.doSendKeys(emailID, un);
	eleUtil.doSendKeys(password, pwd);
	eleUtil.doClick(loginbtn);
	return new Accountspage(driver);
		
	}

	public RegistrationPage goToRegistrationPage(){
	eleUtil.doClick(registerlink);
	return new RegistrationPage(driver);
	}
}
