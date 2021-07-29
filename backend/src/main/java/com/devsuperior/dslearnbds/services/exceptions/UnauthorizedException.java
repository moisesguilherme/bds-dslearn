package com.devsuperior.dslearnbds.services.exceptions;

public class UnauthorizedException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	//401
	public UnauthorizedException(String msg) {
		super(msg);
	}	
}

