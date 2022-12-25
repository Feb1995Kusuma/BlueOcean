package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.opencart.util.Constant;
import com.qa.opencart.util.ElementUtil;

public class RegistrationPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	
	
	private By firstName = By.xpath("//input[@name='firstname']");
	private By lastName = By.xpath("//input[@id ='input-lastname']");
	private By email = By.xpath("//input[@id ='input-email']");
	private By telephone = By.xpath("//input[@id ='input-telephone']");
	private By password = By.xpath("//input[@id ='input-password']");
	private By confirmpassword = By.xpath("//input[@id ='input-confirm']");

	private By subscribeYes = By.xpath("(//label[@class='radio-inline'])[position()=1]/input");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline'])[position()=2]/input");

	private By agreeCheckBox = By.xpath("//input[@name='agree']");
	private By continueButton = By.xpath("//input[@type='submit']");
	private By sucessMessg = By.cssSelector("div#content h1");
	private By logoutLink = By.xpath("//a[@class='list-group-item'][13]");
	private By registerLink = By.xpath("//a[@class='list-group-item'][2]");

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	 

	public boolean accountRegistration(String firstName, String lastName, String email, String telephone, String password, String subscribe) throws InterruptedException {
        
		eleUtil.doSendKeys(this.firstName, firstName);
		eleUtil.doSendKeys(this.lastName, lastName);
		eleUtil.doSendKeys(this.email, email);
		eleUtil.doSendKeys(this.telephone, telephone);
		eleUtil.doSendKeys(this.password, password);
		eleUtil.doSendKeys(this.confirmpassword, password);

		if (subscribe.equalsIgnoreCase("yes")) {
			eleUtil.doClick(subscribeYes);
		} else {
			eleUtil.doClick(subscribeNo);
		}

		eleUtil.doClick(agreeCheckBox);
		eleUtil.doClick(continueButton);

	String mesg	=eleUtil.waitForElementPresence2(sucessMessg, 0).getText();
		System.out.println(mesg);	
		if(mesg.contains(Constant.REGISTER_SUCCESS_MESSG)) {
			eleUtil.doClick(logoutLink);
			eleUtil.doClick(registerLink);
			return true;
		}
	
	return false;
	
}
}



 