package com.example.minorProject1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.minorProject1.models.MyUser;

public interface MyUserRepository extends JpaRepository<MyUser, Integer>{

	MyUser findByUsername(String username);
	
	

}
