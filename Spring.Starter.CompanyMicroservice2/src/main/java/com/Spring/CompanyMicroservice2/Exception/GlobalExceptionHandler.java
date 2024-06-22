package com.Spring.CompanyMicroservice2.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.Spring.CompanyMicroservice2.Entity.ErrorDetails;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
		
	

	
	@ExceptionHandler(CompanyNotExistException.class)
	public ResponseEntity<?> CompanyNotFound(CompanyNotExistException ex){
			
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
	
	@ExceptionHandler(CompanyAlreadyExistError.class)
	public ResponseEntity<?> companyAlreadyExistException(CompanyAlreadyExistError ex){
		
		ErrorDetails ed = new ErrorDetails();
		ed.setErrorCode(HttpStatus.FOUND.value());
		ed.setErrorStatus(HttpStatus.FOUND.name());
		ed.setErrMsg(ex.getLocalizedMessage());
		ed.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(ed,HttpStatus.FOUND);
	}
}
