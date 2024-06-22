package com.Spring.CompanyMicroservice2.Exception;

public class CompanyNotExistException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7193306473073122884L;
	
	public CompanyNotExistException() {
			super("Company not exists..");
		}
}
