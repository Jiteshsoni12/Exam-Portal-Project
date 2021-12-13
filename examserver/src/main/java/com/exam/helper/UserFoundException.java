package com.exam.helper;

public class UserFoundException extends Exception{

	public UserFoundException() {
		super("User with this Username is already present");
	}
	
	public UserFoundException(String msg) {
		super(msg);
	}

}
