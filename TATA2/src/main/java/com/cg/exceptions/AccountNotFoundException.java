package com.cg.exceptions;

public class AccountNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountNotFoundException() {
		super("[ACCOUNT NOT FOUND]");
		// TODO Auto-generated constructor stub
	}

}
