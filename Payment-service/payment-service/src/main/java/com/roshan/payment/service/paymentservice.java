package com.roshan.payment.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.roshan.payment.entity.Payment;
import com.roshan.payment.exception.PaymentNotFoundException;
import com.roshan.payment.repository.PaymentRepository;

@Service
public class paymentservice {
	
	private final  PaymentRepository paymentrepository;
	
	public paymentservice(PaymentRepository paymentrepository) {
		this.paymentrepository=paymentrepository;
	}
	
	
	public Payment createPayment(Payment payment) {
		if(payment.getAmount()==null || payment.getAmount().signum() <=0) {
			throw new IllegalArgumentException("Payment Amount must be greater than  zero ");
		}
		if(payment.getPaymentMethod()==null || payment.getPaymentMethod().isBlank()) {
			throw new IllegalArgumentException("Payment Method Is Required");
		}
		payment.setTransactionId(UUID.randomUUID().toString());
		payment.setStatus("PENDING");
		LocalDateTime now = LocalDateTime.now();
		payment.setCreatedAt(now);
		payment.setUpdatedAt(now);
		return paymentrepository.save(payment);
	}
	
	public Payment getPaymentById(Long id) {
		
		return paymentrepository.findById(id).orElseThrow(() -> new PaymentNotFoundException("payment not found with id"+id));

	}
	
	public List<Payment> getAllPayments(){
		
		return paymentrepository.findAll();
		
		}
	public Payment processPayment(Long id) {
		
		Payment payment =paymentrepository.findById(id).orElseThrow(()-> new PaymentNotFoundException("payment not found with id"+id));
		
		if(!"PENDING".equals(payment.getStatus())) {
			throw new IllegalArgumentException("PAYMENT IS ALREADY BEEN PROCESSED");
		}
		
		payment.setStatus("SUCCESS");
		payment.setUpdatedAt(LocalDateTime.now());
		return paymentrepository.save(payment);
	}

}
