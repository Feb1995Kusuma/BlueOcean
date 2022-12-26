package com.qa.opencart.util;

import java.util.ArrayList;
import java.util.List;

public class Constant {
	
	public static final String Login_PAGE_TITLE="Account Login";
	public static final String Login_PAGE_URL_FRACTION = "route=account/login";
	public static final String PAGE_HEADER = "[[[]]]";
	public static final String Account_Page_Title= "My Account";
	public static final String Account_Page_HEADER = "naveenautomationlabs";
	
	
	public static final int DEFAULT_TIME_OUT = 6;
	public static final int IMAC_IMAGE_COUNT =3;
	public static final int MACBOOKPRO_IMAGE_COUNT =4;
    public static final int MACBOOKAIR_IMAGE_COUNT =4;
    
    public static final String REGISTER_SUCCESS_MESSG = "Your Account Has Been Created!";
    public static final String REGISTER_SHEET_NAME= "Registrationsheet";

	
	public static List<String> getExpectedAccSecList() {
	List<String> expSecList = new ArrayList<String>();
	expSecList.add("My Account");
	expSecList.add("My Orders");
	expSecList.add("My Affiliate Account");
	expSecList.add("Newsletter");
	return expSecList;
	
	}

}
