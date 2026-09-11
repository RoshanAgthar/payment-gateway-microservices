package com.roshan.Order_Service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roshan.Order_Service.Entity.order;
@Repository
public interface order_Repository extends JpaRepository <order,Long> {
	

}
