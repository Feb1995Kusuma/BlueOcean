package com.qa.opencart.Factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	/**
	 * This method is used to initialize the webdriver
	 * @param browserName
	 * @return this will return driver
	 * 
	 * 
	 */
	
	public WebDriver driver;
	public Properties prop;
	public static String highlight;
	public OptionsManager OptionsManager;
	
	//public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	

	
	public WebDriver init_driver(Properties prop) {
	String browsername= prop.getProperty("browser");
	System.out.println("browsername is :"+ browsername);
	highlight= prop.getProperty("highlight");
	OptionsManager = new OptionsManager(prop);
		
	if(browsername.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(com.qa.opencart.Factory.OptionsManager.getChromeOptions());
 //tlDriver.set(new ChromeDriver(OptionsManager.getChromeOptions()));
		
	}else if(browsername.equals("ff")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(OptionsManager.getFirefoxOptions());
//tlDriver.set(new FirefoxDriver(OptionsManager.getFirefoxOptions()));

	}
	else if (browsername.equals("safari")) {
		driver = new SafariDriver();
	}
	else {
		System.out.println("pease pass right browser:" +browsername);
		
	}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get(prop.getProperty("url"));
	
	return driver;
		
	}
	/**
	 * this method is used to initialize the properties
	 * @return
	 * this will return properties prop reference
	 */
	
	public Properties init_prop()  {
	prop= new Properties();
	try {
		FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
		prop.load(ip);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	return prop;
	
	}
	

	

}
