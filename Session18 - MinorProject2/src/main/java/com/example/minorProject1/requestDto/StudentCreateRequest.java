package com.example.minorProject1.requestDto;

import javax.validation.constraints.NotBlank;

import com.example.minorProject1.enums.AccountStatus;
import com.example.minorProject1.models.Student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateRequest {
	
	private String name;
	private String email;
	private String contact;
	private String address;
	
	@NotBlank
	private String username;
	
	@NotBlank
	private String password;
	
	public Student toStudent() {
		
		return Student.builder().name(name).email(email).contact(contact).address(address)
				.accountStatus(AccountStatus.ACTIVE).build();
	}
	
	public UserCreateRequest toUserCreateRequest() {
		return UserCreateRequest.builder().username(username).password(password)
				.student(toStudent()).build();
	}

}
