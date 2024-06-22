package com.Spring.CompanyMicroservice2.Exception;

public class CompanyAlreadyExistError extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5079811555726754887L;
	
	public CompanyAlreadyExistError() {
			super("Company Already Exist....");
	}
}	
