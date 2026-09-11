package com.roshan.Order_Service.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class order {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	
	private Long id;

   private Long	userId;
   private String	productName;
   private Long	quantity;
   private BigDecimal amount;
   private String status;
   private LocalDateTime createdAt;
   private LocalDateTime updatedAt;
   public Long getId() {
	return id;
   }
   public void setId(Long id) {
	this.id = id;
   }
   public Long getUserId() {
	return userId;
   }
   public void setUserId(Long userId) {
	this.userId = userId;
   }
 
   public Long getQuantity() {
	return quantity;
   }
   public void setQuantity(Long quantity) {
	this.quantity = quantity;
   }
   public BigDecimal getAmount() {
	return amount;
   }
   public void setAmount(BigDecimal amount) {
	this.amount = amount;
   }
   public String getStatus() {
	return status;
   }
   public void setStatus(String status) {
	this.status = status;
   }
   public LocalDateTime getCreatedAt() {
	return createdAt;
   }
   public void setCreatedAt(LocalDateTime createdAt) {
	this.createdAt = createdAt;
   }
   public LocalDateTime getUpdatedAt() {
	return updatedAt;
   }
   public void setUpdatedAt(LocalDateTime updatedAt) {
	this.updatedAt = updatedAt;
   }
   public String getProductName() {
	return productName;
   }
   public void setProductName(String productName) {
	this.productName = productName;
   }

}
