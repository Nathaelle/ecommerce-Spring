package com.ecommerce.engine.authentication.exceptions;

public class UserAlreadyExistException extends Exception {

	private static final long serialVersionUID = 7293527335634440586L;


	public UserAlreadyExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserAlreadyExistException(String message) {
		super(message);
	}

	
}
