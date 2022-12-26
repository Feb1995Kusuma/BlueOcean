package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.util.Constant;
import com.qa.opencart.util.ElementUtil;

public class  LoginppageMain {
	
	//1. declare own private driver
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//2. to initialize the driver with help constructor
	public LoginppageMain(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		
	}
	
	//3. By locator
	private By emailID = By.xpath("//input[@id ='input-email']");
	private By password = By.xpath("//input[@id='input-password']");
	private By loginbtn = By.xpath("//input[@value ='Login']");
	private By registerlink = By.xpath("//a[@class='list-group-item'][2]");
	private By forgetPwdLink = By.xpath("(//a[text()='Forgotten Password'])[1]");
    private By header = By.cssSelector("div#logo");
    		
    		
    //4. page actions/ page methods/ functionality/behavior of the page/ no assertion

	public boolean getLoginPageTitle() {
		return eleUtil.doGetTitle(Constant.Login_PAGE_TITLE, Constant.DEFAULT_TIME_OUT);
	}
	
	public String getPageHeaderText() {
		return eleUtil.doGetText1(header);
	}
	
	public boolean isForgetPwdLinkExist() {
		return eleUtil.doisDisplayed(forgetPwdLink);
	}
	
	public boolean isRegisterLinkExist() {
		return eleUtil.doisDisplayed(registerlink);
	}
	
	public Accountspage doLogin(String un, String pwd) {
	System.out.println("login with: " + un + " : " + pwd);
	eleUtil.doSendKeys(emailID, un);
	eleUtil.doSendKeys(password, pwd);
	eleUtil.doClick(loginbtn);
	return new 	Accountspage(driver);
	}

	public RegistrationPage goToRegistrationPage() {
		eleUtil.doClick(registerlink);
		return new RegistrationPage(driver);
		}

}
