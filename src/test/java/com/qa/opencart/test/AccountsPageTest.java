package com.qa.opencart.test;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.util.Constant;

public class AccountsPageTest extends BaseTest 
{
	public WebDriver driver;

	
	@BeforeClass
	public void accPageSetup() {
	accountspage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	

	
	@Test(priority = 1)
	public void accPageTitleTest() {
		boolean actTitle = accountspage.getAccountpageTitle();
		System.out.println("acc page title: +actTitle");
		Assert.assertTrue(actTitle, Constant.Account_Page_Title);
	}
	
	
	@Test(priority = 2)
	public void accPageHeaderTest() {
	boolean header	= accountspage.getAccountspageHeader() != null;
	System.out.println("acc page header is: + header");
	Assert.assertTrue(header, Constant.Account_Page_HEADER);	
	}
	
	
	@Test(priority = 3)
	public void isLogoutExistTest() {
	Assert.assertTrue(accountspage.isLogoutLinkExist());
	}
	
	@Test (priority =4)
	public void accPageSectionsTest() {
	List<String> actAccSecList	= accountspage.getAccountSecList();
	Assert.assertEquals(actAccSecList, Constant.getExpectedAccSecList());
	}
	
	@DataProvider
	public Object[][] productData() {
		return new Object[][] {
			{"MacBook"}, 
			{"Apple"}, 
			{"Samsung"},
			
		};
	}
	
	@Test (priority = 5, dataProvider ="productData")
	public void searchTest(String productName) {
	searchResultPage = accountspage.doSearch(productName);
	Assert.assertEquals(searchResultPage.getProductListCount(), false);
	}
	
	@DataProvider
	public Object[][] productSelectData() {
		return new Object[][] { 
			{"MacBook" ,  "MacBook Pro"}, 
			{"iMac" , "iMac"},
			{"Samsung", "Samsung Galaxy Tab 10.1"},
			{"Apple", "Apple Cinema 30\""}
			
			};
	}
	
	@Test(priority = 6, dataProvider= "productSelectData")
	public void selectProductTest(String productName, String mainProductName) {
	searchResultPage = accountspage.doSearch(productName);
	productInfoPage= searchResultPage.selectProduct(mainProductName);
	Assert.assertEquals(productInfoPage.getProductHeader(),mainProductName);
	}
	
	
	

}
