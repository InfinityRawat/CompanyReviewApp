package com.Spring.JobMicroservice2.GlobalExceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.Spring.JobMicroservice2.Models.ErrorDetails;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
		
	
	@ExceptionHandler(JobAlreadyExistException.class)
	public ResponseEntity<?> JobAlreadyExistException(JobAlreadyExistException ex){
		
		ErrorDetails ed = new ErrorDetails();
		ed.setErrorCode(HttpStatus.FOUND.value());
		ed.setErrorStatus(HttpStatus.FOUND.name());
		ed.setErrMsg(ex.getLocalizedMessage());
		ed.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(ed,HttpStatus.FOUND);
	}
	
	@ExceptionHandler(JobNotFoundException.class)
	public ResponseEntity<?> JobNotExistException(JobNotFoundException ex){
		
		ErrorDetails ed = new ErrorDetails();
		ed.setErrorCode(HttpStatus.NOT_FOUND.value());
		ed.setErrorStatus(HttpStatus.NOT_FOUND.name());
		ed.setErrMsg(ex.getLocalizedMessage());
		ed.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(ed,HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> EntityNotFound(EntityNotFoundException ex){
			
		ErrorDetails ed = new ErrorDetails();
		ed.setErrorCode(HttpStatus.NOT_FOUND.value());
		ed.setErrorStatus(HttpStatus.NOT_FOUND.name());
		ed.setErrMsg(ex.getLocalizedMessage());
		ed.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(ed,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ServiceNotAvailableException.class)
	public ResponseEntity<?> ServiceNotAvailable(ServiceNotAvailableException ex){
			
		ErrorDetails ed = new ErrorDetails();
		ed.setErrorCode(HttpStatus.BAD_GATEWAY.value());
		ed.setErrorStatus(HttpStatus.BAD_GATEWAY.name());
		ed.setErrMsg(ex.getLocalizedMessage());
		ed.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(ed,HttpStatus.NOT_FOUND);
	}
	
	
}
