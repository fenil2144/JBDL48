package com.example.SpringSecurityDemo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<MyUser, Integer>{

	MyUser findByEmail(String email);

}
