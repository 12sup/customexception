package com.te.springboothibernate.validation.custom.exception;

public class UserNotFoundException extends Exception {

	public UserNotFoundException(String message) {
		super(message);
	}

}
