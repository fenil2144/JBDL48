package com.example.SpringSecurityDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@GetMapping("/demo")
	public String getDemo() {
		return "Demo";
	}
	
	//DFE3BC9C0DEE96A2E564D6CA0110301F
	//40B670AEE93A9E0CD28E12431A0016C2
	
	//6299902e-0347-40aa-8cfc-8f724472c8c5
	//40b92517-ac25-4b21-9e7f-adc8c01ea702
	
	//Request Comes to the Backend:
//	1) JSESSIONID sent is of unauthenticated session/user
//		BE: Verify the session ID and redirect to /login api page
//		FE: Pass the credentials entered by user and calls the login with unauthenticated JSESSIONID
//		BE: Verify the Credentials and generate new authenticated JSESSIONID and pass it in the response header as set-Cookie.
//		FE: Will redirect to the original url with Authenticated JSESSIONID
//	2) JSESSIONID sent is of authenticated session/user
//		BE: Verify the session id and return the requested resource.
	
	
	@GetMapping("/developercode")
	public String getDeveloperInfo() {
		return "Developer Code Method";
	}
	
	@GetMapping("/qacode")
	public String getQaInfo() {
		return "QA Info Method";
	}
	
	@GetMapping("/generalcode")
	public String getGeneralCode() {
		return "General Info Method";
	}
	
	@GetMapping("/home")
	public String getHome() {
		return "Home Info Method";
	}

}
