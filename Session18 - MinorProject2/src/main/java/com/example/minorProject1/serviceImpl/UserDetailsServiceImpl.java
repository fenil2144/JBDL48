package com.example.minorProject1.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.minorProject1.models.MyUser;
import com.example.minorProject1.repository.MyUserRepository;
import com.example.minorProject1.repository.UserCacheRepository;
import com.example.minorProject1.requestDto.UserCreateRequest;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	MyUserRepository myUserRepository;
	
	@Autowired
	UserCacheRepository userCacheRepository;
	
	@Value("${user.authority.admin}")
	String adminAuthority;
	
	@Value("${user.authority.student}")
	String studentAuthority;

	
	//first 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		MyUser myUser = userCacheRepository.get(username);
		if(myUser == null)
			myUser = myUserRepository.findByUsername(username);
		if(myUser != null)
			userCacheRepository.set(myUser);
		
		return myUser;
	}
	
	public MyUser createUser(UserCreateRequest userCreateRequest) {
		
		MyUser.MyUserBuilder myUserBuilder = MyUser.builder().username(userCreateRequest.getUsername())
		.password(passwordEncoder.encode(userCreateRequest.getPassword()));
		
		if(userCreateRequest.getStudent() != null)
			myUserBuilder.authority(studentAuthority);
		
		else {
			myUserBuilder.authority(adminAuthority);

		}
		return myUserRepository.save(myUserBuilder.build());
	}

}
