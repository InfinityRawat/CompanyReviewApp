package com.Spring.JobMicroservice2.GlobalExceptions;

public class JobAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2662998299508876671L;
	
	public JobAlreadyExistException() {
			super("Job Already Exist in datasjource");
	}

}
