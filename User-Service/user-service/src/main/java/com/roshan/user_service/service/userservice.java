package com.roshan.user_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.roshan.user_service.Entity.users;
import com.roshan.user_service.exception.UserNotFoundException;
import com.roshan.user_service.repository.userrepository;

@Service
public class userservice {
	private final userrepository userrepo;
	public userservice(userrepository userrepo){
		this.userrepo=userrepo;
	}
	
	public users  create(users user) {
		if(user.getName()==null || user.getName().isBlank()) {
			throw new IllegalArgumentException("order name is empty!! ");
		}
		if(user.getPassword()==null || user.getPassword().isEmpty()) {
		throw new IllegalArgumentException("password is Empty ");
		}
		 return userrepo.save(user);
	}
	
	public users getById(Long id) {
		return userrepo.findById(id).orElseThrow(() -> new  UserNotFoundException("orderid is not found"+id));
	}
	public List<users>getUsersAll(){
		return userrepo.findAll();
	}

}
