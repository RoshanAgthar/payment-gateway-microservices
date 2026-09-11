package com.roshan.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roshan.user_service.Entity.users;

@Repository
public interface userrepository extends JpaRepository<users,Long> {
	
	
	

}
