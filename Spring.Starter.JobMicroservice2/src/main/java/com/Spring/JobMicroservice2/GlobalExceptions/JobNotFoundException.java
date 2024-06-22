package com.Spring.JobMicroservice2.GlobalExceptions;

public class JobNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4450191678923052867L;
		
	public JobNotFoundException() {
		super("Job not Found");
	}
}
