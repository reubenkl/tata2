package com.cg.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<String> handleAccountException(AccountNotFoundException anf ){
		return new ResponseEntity<String> (anf.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<String> handlePackException(PackNotFoundException pnf ){
		return new ResponseEntity<String> (pnf.getMessage(), HttpStatus.NOT_FOUND);
	}
}
