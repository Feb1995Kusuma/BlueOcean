package com.qa.opencart.test;

import java.util.Map;
import java.util.function.BiConsumer;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.util.Constant;

public class ProductInfoPageTest extends BaseTest
{
	private WebDriver driver;

	
	@BeforeClass
	public void productInfoSetup() {
		accountspage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority =1)
	public void productHeaderTest() {
		
		searchResultPage = accountspage.doSearch("MacBook");
		productInfoPage= searchResultPage.selectProduct("MacBook Pro");
		Assert.assertEquals(productInfoPage.getProductHeader(),"MacBook Pro");
	}
	
	@Test(priority = 2)
	public void productImagesCountTest() {
		searchResultPage = accountspage.doSearch("iMac");
		productInfoPage= searchResultPage.selectProduct("iMac");
		Assert.assertEquals(productInfoPage.getProductImagesCount(), Constant.IMAC_IMAGE_COUNT);
	}
	
	@Test(priority = 3)
	public void productInfoTest() {
	
	searchResultPage = accountspage.doSearch("MacBook");
	productInfoPage= searchResultPage.selectProduct("MacBook Pro");
	Map<String, String>	actProductInfoMap = productInfoPage.getProductInfo();
	actProductInfoMap.forEach(new BiConsumer<String, String>() {
		public void accept(String k, String v) {
			System.out.println(k + ":" + v);
		}
	});
	softAssert.assertEquals(actProductInfoMap.get("name"), "MacBook Pro");
	softAssert.assertEquals(actProductInfoMap.get("Brand"), "Apple");
	softAssert.assertEquals(actProductInfoMap.get("price"), "$2,000.00");
	softAssert.assertAll();
	
	}
	
	

}
