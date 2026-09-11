package com.roshan.user_service.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Global_Exception {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Error_Response> handleUserNotFound(UserNotFoundException userNotFound){
		Error_Response error =new Error_Response (LocalDateTime.now(),HttpStatus.NOT_FOUND.value(),"UserNotFound",userNotFound.getMessage(),"");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Error_Response> handleBadRequest(IllegalArgumentException ex){
		Error_Response error =new Error_Response (LocalDateTime.now(),HttpStatus.BAD_REQUEST.value(),"Bad Request",ex.getMessage(),"");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Error_Response> handleException(Exception ex){
		Error_Response error =new Error_Response (LocalDateTime.now(),HttpStatus.INTERNAL_SERVER_ERROR.value(),"Internal Server Error","Something Went Wrong .please try again later.","");
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}
	

}
