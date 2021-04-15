package com.consume.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@GetMapping(path = "/getAll")
	public ResponseEntity<String> getAllUsers()
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<String> response=null;
		try {
			response = restTemplate.exchange("http://localhost:8080/users/?page=1&limit=100", HttpMethod.GET, entity,String.class);
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getLocalizedMessage());
		}
		 return response;
	}

}
