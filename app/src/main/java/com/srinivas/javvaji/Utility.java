package com.srinivas.javvaji;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Class which has Utility methods
 * 
 */
public class Utility {
	private static Pattern pattern;
	private static Matcher matcher;
	//Email Pattern
	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static final String MOBILE_PATTERN = "\\d{10}";
	
	/**
	 * Validate Email with regular expression
	 * 
	 * @param mobileNo
	 * @return true for Valid Email and false for Invalid Email
	 */
	public static boolean validate(String mobileNo) {
		if(mobileNo.length() > 10)
			mobileNo = mobileNo.substring(mobileNo.length()-10);
		pattern = Pattern.compile(MOBILE_PATTERN);
		matcher = pattern.matcher(mobileNo);
		return matcher.matches();
 
	}
	/**
	 * Checks for Null String object
	 * 
	 * @param txt
	 * @return true for not null and false for null String object
	 */
	public static boolean isNotNull(String txt){
		return txt!=null && txt.trim().length()>0 ? true: false;
	}
}