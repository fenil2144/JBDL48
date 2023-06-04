package com.example.wallet;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserCreateRequest {

	@NotBlank
	private String name;
	
	@NotBlank
	private String phoneNumber;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String password;
	
	private String dob;
	
	private String country;
		
	@NotBlank
	private UserIdentifier userIdentifier;
	
	@NotBlank
	private String identifierValue;
	
	public User toUser() {
		
		return User.builder()
				.name(this.name).phoneNumber(this.phoneNumber)
				.email(this.email).country(this.country)
				.dob(this.dob)
				.userIdentifier(this.userIdentifier)
				.identifierValue(this.identifierValue).build();
	}

}
