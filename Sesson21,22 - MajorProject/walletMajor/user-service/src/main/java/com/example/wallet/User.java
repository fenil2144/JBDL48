package com.example.wallet;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails,Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(unique = true)
	private String phoneNumber;
	
	@Column(unique = true)
	private String email;
	
	private String password;
	
	private String dob;
	
	private String country;
	
	private String authorities;
	
	@Enumerated(value = EnumType.STRING)
	private UserIdentifier userIdentifier;
	
	private String identifierValue;
	
	@CreationTimestamp
	private Date createdOn;
	
	@UpdateTimestamp
	private Date updatedOn;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String[] authorities = this.authorities.split(UserConstants.AUTHORITIES_DELIMITER);
		return Arrays.stream(authorities).map(x -> new SimpleGrantedAuthority(x))
				.collect(Collectors.toList());
	}

	@Override
	public String getUsername() {
		return this.phoneNumber;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
