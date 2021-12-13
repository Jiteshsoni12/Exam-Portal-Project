package com.exam.helper;

public class UserNotFoundException extends Exception{
	
	public UserNotFoundException() {
		super("User with this Username is not present in DB ! try different ");
	}
	
	public UserNotFoundException(String msg) {
		super(msg);
	}

}
