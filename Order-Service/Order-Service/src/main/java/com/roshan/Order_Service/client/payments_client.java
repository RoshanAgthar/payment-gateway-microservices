package com.roshan.Order_Service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.roshan.Order_Service.dto.PaymentRequest;

@FeignClient(name="PAYMENT-SERVICE")
public interface payments_client {
   @PostMapping("/api/payments")
	Object createPayment(@RequestBody PaymentRequest paymentrequest);
}
