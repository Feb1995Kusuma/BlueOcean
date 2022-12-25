package com.qa.opencart.test;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.util.Constant;
import com.qa.opencart.util.ExcelUtil;

public class RegistrationPageTest extends BaseTest
{
	public WebDriver driver;

	
    @BeforeClass
    public void setupRegistration() {
    registrationPage=loginpage.goToRegistrationPage();
    }
	
	public String getRandomEmail() {
		Random randomgenerator = new Random();
		String email = "decemberautomation"+randomgenerator.nextInt(1000)+"@gmail.com";
		System.out.println(email);
		return email;
	}
	
	@DataProvider
	public Object[][] getRegisterData() {
	 return ExcelUtil.getTestData(Constant.REGISTER_SHEET_NAME);
	}
	
	@Test(dataProvider = "getRegisterData")
	public void userRegistrationTest(String firstName, String lastName,
			                         String telephone, String password, 
			                         String subscribe) {
	try {
		Assert.assertTrue(registrationPage.accountRegistration(firstName, lastName,  getRandomEmail(), 
		         telephone, password, subscribe));
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	
}
