package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.util.ElementUtil;

public class LoginPage {
	
	//1. declare private driver
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//2. page constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver; 
		}
	
	//3. By locators - used encapsulation concept so private
	private By emailid = By.xpath("//input[@id = 'input-email']");
	private By passwd = By.xpath("//input[@id = 'input-password']");
	private By loginbtn = By.xpath("//input[@class='btn btn-primary']");
	private By forgotpwdLink = By.xpath("(//a[text()='Forgotten Password'])[1]");
	private By registerlink = By.xpath("(//a[@class='list-group-item'])[2]");
	
	//4. page Actions:
	public String getLoginPageTitle() {
		return driver.getTitle();
		
	}
	
	public String getloginpageurl() {
		return driver.getCurrentUrl();
	}

	
	
	public boolean isforgotpwdLinkExist() {
		return driver.findElement(forgotpwdLink).isDisplayed();
		
	}
	
	public boolean isregisterlinkExist() {
		return driver.findElement(registerlink).isDisplayed();
	}
	
	public Accountspage doLogin(String un, String pwd) {
	System.out.println("login with:" + un + ":" + pwd);
	driver.findElement(emailid).sendKeys(un);
	driver.findElement(passwd).sendKeys(pwd);
	driver.findElement(loginbtn).click();
	return new Accountspage(driver);
	}
	
	

	public RegistrationPage goToRegisterationpage() 
	{
	driver.findElement(By.xpath("(//a[@class='list-group-item'])[2]")).click();
	return new RegistrationPage(driver);	
}

	

}
