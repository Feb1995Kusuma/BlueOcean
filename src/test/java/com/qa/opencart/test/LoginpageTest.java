package com.qa.opencart.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.util.Constant;

public class LoginpageTest extends BaseTest {
	
	public WebDriver driver;


	@Test(priority = 1)
	public void loginPageTitleTest() {
    Assert.assertTrue(loginpage.getLoginPageTitle());	
  
	}
  
	@Test(priority = 2)
	public void loginPageHeaderTest() {
	String header = loginpage.getPageHeaderText();
	System.out.println("ip header is: " + header);
	Assert.assertNotSame(Constant.PAGE_HEADER, Constant.DEFAULT_TIME_OUT);
	}
	
	@Test(priority = 3)
	public void forgetPwdLinkTest() {
	Assert.assertTrue(loginpage.isForgetPwdLinkExist());
	}
	
	@Test(priority = 4)
	public void registerLinkTest() {
		Assert.assertTrue(loginpage.isRegisterLinkExist());
	}
	
	@Test(priority = 5)
	public void loginTest() {
		loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

}
