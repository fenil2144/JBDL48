package com.example.SpringBootDemo.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ImageController {
	
	@GetMapping(value = "/image",produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImage(@RequestParam("id") int id,
			@RequestParam(value = "width", required = false, defaultValue = "200") int width,
			@RequestParam(value = "height", required = false, defaultValue = "300") int height) {
		
		String url = "https://picsum.photos/id/"+id+"/"+width+"/"+height;
		
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, byte[].class);
	}

}
