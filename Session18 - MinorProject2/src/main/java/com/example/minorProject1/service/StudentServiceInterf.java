package com.example.minorProject1.service;

import com.example.minorProject1.models.Student;
import com.example.minorProject1.requestDto.StudentCreateRequest;

public interface StudentServiceInterf {

	Student save(StudentCreateRequest studentCreateRequest);
	
	Student findById(int studentId);

}
