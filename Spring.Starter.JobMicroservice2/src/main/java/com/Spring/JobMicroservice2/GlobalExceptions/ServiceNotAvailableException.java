package com.Spring.JobMicroservice2.GlobalExceptions;

public class ServiceNotAvailableException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3194670691130905330L;
	
	public ServiceNotAvailableException(Exception e) {
		super(e);
	}

		
}
