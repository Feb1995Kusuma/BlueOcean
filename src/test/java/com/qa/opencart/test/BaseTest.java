package com.qa.opencart.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.Factory.DriverFactory;
import com.qa.opencart.pages.Accountspage;
import com.qa.opencart.pages.Loginpage;
import com.qa.opencart.pages.ProductInfopage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.pages.SearchResultsPage;

public class BaseTest {
	
	DriverFactory df;
	Properties prop;
	WebDriver driver;
	Loginpage loginpage;
	Accountspage accountspage;
	SearchResultsPage searchResultPage;
	ProductInfopage productInfoPage;
	RegistrationPage registrationPage;
	SoftAssert softAssert;
	
	
	
	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		loginpage= new Loginpage(driver);
		softAssert = new SoftAssert();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
