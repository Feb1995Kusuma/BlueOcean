package com.qa.opencart.test;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.util.Constant;
import com.qa.opencart.util.ExcelUtil;

public class RegistrationPageTest extends BaseTest
{
  public WebDriver driver;

  RegistrationPage registrationPage;

     
	@BeforeClass
	public void setupRegistration() {
		WebDriver driver;
		registrationPage=loginpage.goToRegisterationpage();
	}
	
	public String getRandomEmail() {
		Random randomgenerator = new Random();
		String email = "Februaryautomation"+randomgenerator.nextInt(1000)+"@gmail.com";
		return email;
	}
	
	@DataProvider
	public Object[][] getRegisterData() {
	 return ExcelUtil.getTestData(Constant.REGISTER_SHEET_NAME);
	}
	
	@Test(dataProvider = "getRegisterData")
	public void userRegistrationTest(String firstName, String lastName,
			                         String telephone,String password, String subscribe) throws InterruptedException {
	Assert.assertTrue(registrationPage.accountRegistration(firstName, lastName,  getRandomEmail(), 
             telephone, password, subscribe));
	}
	
	
	
}
