package com.example.adyenconnect;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.adyenconnect.dto.Quote;

public class TestwithRestTemplate {
	RestTemplate restTemplate;
	private HttpHeaders headers;
	
	@BeforeMethod
	public void initializeMethods() {
		headers = new HttpHeaders();        
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");
	}
	
	@Test
	public void testSample() {
		
		System.out.println("Test Started:");
		
		headers = new HttpHeaders();        
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");
		
		restTemplate=new RestTemplate();
		 HttpEntity<String> entity = new HttpEntity<String>(headers); 
		
		Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		
		System.out.println("Response:"+quote);
		Assert.assertTrue(quote.getType().contains(""));
		
	}
}
