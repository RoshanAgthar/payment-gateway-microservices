package com.roshan.payment.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(PaymentNotFoundException.class)
	public ResponseEntity<ErrorResponse> handlePaymentNotFound(PaymentNotFoundException ex){
		
		ErrorResponse error=new ErrorResponse(LocalDateTime.now(),HttpStatus.NOT_FOUND.value(),"payment not found",ex.getMessage(),"");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	 public ResponseEntity<ErrorResponse> handleBadRequest(
	            IllegalArgumentException ex) {

	        ErrorResponse error = new ErrorResponse(
	                LocalDateTime.now(),
	                HttpStatus.BAD_REQUEST.value(),
	                "Bad Request",
	                ex.getMessage(),
	                ""
	        );

	        return ResponseEntity
	                .status(HttpStatus.BAD_REQUEST)
	                .body(error);
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<ErrorResponse> handleGeneralException( Exception ex) {

	        ErrorResponse error = new ErrorResponse(
	                LocalDateTime.now(),
	                HttpStatus.INTERNAL_SERVER_ERROR.value(),
	                "Internal Server Error",
	                "Something went wrong. Please try again later.",
	                ""
	        );

	        return ResponseEntity
	                .status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body(error);
	    }

}
