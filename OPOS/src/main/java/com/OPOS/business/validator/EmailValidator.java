package com.OPOS.business.validator;

public class EmailValidator {
	
	public static boolean isValidEmail(String email)
	{
		return email.matches("(.*)@(.*)");
	}

}
