package com.roshan.Order_Service.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.roshan.Order_Service.Entity.order;
import com.roshan.Order_Service.Repository.order_Repository;
import com.roshan.Order_Service.client.userClient;
import com.roshan.Order_Service.dto.PaymentRequest;

@Service
public class order_service {
	
	   private final order_Repository order_repo;
	    private final userClient userClient;
	    private final PaymentRequest paymentrequest;

	    public order_service(order_Repository order_repo, userClient userClient,PaymentRequest paymentrequest) {
	        this.order_repo = order_repo;
	        this.userClient = userClient;
	        this.paymentrequest=paymentrequest;
	    }
	  public Object testUserConnection(Long userId) {
	        return userClient.getUserById(userId);
	    }
	 
   public order createOrder(order order) {
	   try {
		   userClient.getUserById(order.getUserId());
	   }
	   catch(Exception ex) {
		   throw new RuntimeException("userId is not Found"+ order.getUserId());
	   }
	  
	   if(order.getAmount()==null || order.getAmount().signum() <=0) {
		   throw new IllegalArgumentException("order amount must be greater than zero");
	   }
	   order.setStatus("CREATED");
	    LocalDateTime now = LocalDateTime.now();
	    
	    order.setCreatedAt(now);
	    order.setUpdatedAt(now);
	    
	    order savedOrder= order_repo.save(order); 
	    
	    PaymentRequest paymentrequest = new PaymentRequest();
	    paymentrequest.setOrderId(order.getId());
	    paymentrequest.setPayment(order.getAmount());
	    paymentrequest.setUserId(order.getUserId());
	    paymentrequest.setPaymentMethod("CARD");
	    
	    return savedOrder;
   }
   
   public order findById(Long id) {
	   
	   return order_repo.findById(id).orElseThrow(()-> new RuntimeException("order not found id"+id));
   }
   public List<order> findAllOrders(){
	   return order_repo.findAll();
   }

}
