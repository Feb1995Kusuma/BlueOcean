package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.util.Constant;

public class LoginpageTest extends BaseTest
{
	
	@Test(priority =1)
	public void loginpagetitletest() {
	String actTitle = loginpage.getLoginPageTitle();
	System.out.println("page title:" + actTitle );
	Assert.assertEquals(actTitle, Constant.Login_PAGE_TITLE);
	}
	
	@Test(priority =2)
	public void loginpageurltest() {
	String acturl	= loginpage.getloginpageurl();
	System.out.println("page url : " + acturl);
	Assert.assertTrue(acturl.contains(Constant.Login_PAGE_URL_FRACTION));
		
	}
	
	@Test(priority =3)
	public void forgetpwdlinktest() {
		Assert.assertTrue(loginpage.isforgotpwdLinkExist());
		
	}
	
	@Test(priority =4)
	public void registerlinktest() {
		Assert.assertTrue(loginpage.isregisterlinkExist());
		
	}
	
	@Test(priority =5)
	public void loginTest() {
	accountspage= loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	Assert.assertTrue(accountspage.getAccountpageTitle(), Constant.Account_Page_Title);
	}

}
