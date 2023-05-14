package com.example.minorProject1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.minorProject1.models.Admin;
import com.example.minorProject1.models.Author;
import com.example.minorProject1.models.MyUser;
import com.example.minorProject1.repository.AdminRepositoryInterf;
import com.example.minorProject1.repository.AuthorRepositoryInterf;
import com.example.minorProject1.repository.MyUserRepository;

@SpringBootApplication
public class MinorProject1Application implements CommandLineRunner{
	
	@Autowired
	AuthorRepositoryInterf authorRepositoryInterf;
	
	@Autowired
	AdminRepositoryInterf adminRepositoryInterf;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	MyUserRepository myUserRepository;
	
	@Value("${user.authority.admin}")
	String adminAuthority;
	
	@Value("${user.authority.student}")
	String studentAuthority;

	public static void main(String[] args) {
		SpringApplication.run(MinorProject1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("In Main Method");
		
//		List<Author> authorList = authorRepositoryInterf.findByAgeGreaterThanEqualAndCountryAndNameStartingWith(
//				20,"India","M");
//		authorList.stream().map(author -> author.getBookList())
//			.forEach(books ->  System.out.println(books.size()));
		
//		MyUser myUser = MyUser.builder().username("raj").password(passwordEncoder.encode("raj123"))
//				.authority(adminAuthority).build();
//		
//		myUser = myUserRepository.save(myUser);
//		
//		Admin admin = Admin.builder().age(30).name("Raj Srivastava").myUser(myUser).build();
//		
//		adminRepositoryInterf.save(admin);
	}

}
