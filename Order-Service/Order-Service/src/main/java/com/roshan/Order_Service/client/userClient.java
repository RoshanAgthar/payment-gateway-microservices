package com.roshan.Order_Service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="USER-SERVICE")
public interface userClient {
	
	@GetMapping("/api/users/{id}")
	Object getUserById(@PathVariable Long id);

}
