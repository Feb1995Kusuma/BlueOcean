package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.util.Constant;
import com.qa.opencart.util.ElementUtil;

public class Accountspage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By accountsection = By.cssSelector("div#content h2");
    private By header = By.cssSelector("div#logo .img-responsive");
	private By searchfield = By.xpath("(//input[@name ='search'])[1]");
	private By searchButton = By.cssSelector("div#search  button");
	private By logoutlink = By.linkText("Logout");
	
	
	public Accountspage(WebDriver driver) {
		this.driver = driver;
		eleUtil= new ElementUtil(driver);
		
	}
	
	
	public boolean getAccountpageTitle() {
		return eleUtil.doGetTitle(Constant.Account_Page_Title, Constant.DEFAULT_TIME_OUT);
		
	}
	
	public String getAccountspageHeader() {
		return eleUtil.doGetText1(header);
	}
	
	public boolean isLogoutLinkExist() {
		return eleUtil.doisDisplayed(logoutlink);
	}
	
	public void logout() {
		if(isLogoutLinkExist()) {
			eleUtil.doClick(logoutlink);
		}
	}
	
	public List<String> getAccountSecList() {
	List<WebElement> accSecList	= eleUtil.waitForElementsToBeVisible(accountsection, 10);
	List<String> accSecValList = new ArrayList<String>();
	for(WebElement e:accSecList) {
		String text = e.getText();
		accSecValList.add(text);
	}
	
	return accSecValList;
	}
	
	
	public boolean isSearchExist() {
		return ((ElementUtil) driver).doisDisplayed(searchfield);
	}
	
	public SearchResultsPage doSearch(String productName) {
		System.out.println("searching the product:" + productName);
		eleUtil.doSendKeys(searchfield, productName);
		eleUtil.doClick(searchButton);
		return new SearchResultsPage(driver);
		
	}
	

}
