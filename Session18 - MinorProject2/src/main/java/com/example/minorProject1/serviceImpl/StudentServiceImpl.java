package com.example.minorProject1.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.example.minorProject1.models.MyUser;
import com.example.minorProject1.models.Student;
import com.example.minorProject1.repository.StudentRepositoryInterf;
import com.example.minorProject1.requestDto.StudentCreateRequest;
import com.example.minorProject1.requestDto.UserCreateRequest;
import com.example.minorProject1.service.StudentServiceInterf;

@Service
public class StudentServiceImpl implements StudentServiceInterf{
	
	@Autowired
	StudentRepositoryInterf studentRepositoryInterf;
	
	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Override
	public Student save(StudentCreateRequest studentCreateRequest) {
		
		UserCreateRequest userCreateRequest = studentCreateRequest.toUserCreateRequest();
		MyUser myUser = userDetailsService.createUser(userCreateRequest);
		
		Student student = studentCreateRequest.toStudent();
		student.setMyUser(myUser);		
		
		return studentRepositoryInterf.save(student);
	}

	@Override
	public Student findById(int studentId) {
		return studentRepositoryInterf.findById(studentId).orElseThrow(
				() -> new RuntimeException("Student Not Found"));
	}

}
