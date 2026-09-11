package com.roshan.payment.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roshan.payment.entity.Payment;

import com.roshan.payment.service.paymentservice;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
	
	private paymentservice paymentservice;
	
	public PaymentController(paymentservice paymentservice) {
		this.paymentservice=paymentservice;
	}
	@GetMapping("/test")
	public String testPaymentService() {
		return "payment service is working !";
	}
	
	@PostMapping()
	public ResponseEntity<Payment>  createPayment(@RequestBody Payment payment) {
		Payment savedPayment = paymentservice.createPayment(  payment);
		
		return ResponseEntity.ok(savedPayment);
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
		
		Payment payment=paymentservice.getPaymentById(id);
		return ResponseEntity.ok(payment);
	}
	
	@GetMapping
  public ResponseEntity<List<Payment>> getAllPayments(){
		
		return ResponseEntity.ok(paymentservice.getAllPayments());
	}
	
	@PutMapping("/{id}/process")
	public ResponseEntity<Payment> processPayment(
	        @PathVariable Long id) {

	    Payment payment = paymentservice.processPayment(id);

	    return ResponseEntity.ok(payment);
	}

}
