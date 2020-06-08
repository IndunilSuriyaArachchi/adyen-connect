package com.example.adyenconnect;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.net.ssl.SSLContext;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import com.example.adyenconnect.dto.AdyenDirectAmount;
import com.example.adyenconnect.dto.AdyenDirectAuthoriseRequest;
import com.example.adyenconnect.dto.AdyenDirectCard;
import com.example.adyenconnect.dto.PayMethods;
import com.example.adyenconnect.dto.Quote;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class AdyenDirectConnectApplicationTests {

	RestTemplate restTemplate;
	private HttpHeaders headers;
	//private String checkoutUrl=env.getProperty("adyen.checkout.api.url");
	
	@Value("${adyen.direct.authorise.url}")
	private String authtUrl;
	
	@Value("${adyen.direct.username}")
	private String username;
	
	@Value("${adyen.direct.password}")
	private String password;
	
	@Value("${adyen.connect.merchant.account}")
	private String merchangeAccount;
	
	@Value("${adyen.connect.secure.tls.version}")
	private String tlsVersion;
	
	
	private ResponseEntity<String> responseEntity;
	private String responseBody;
	
	
	@BeforeMethod
	public void initializeMethods() {
		headers = new HttpHeaders();        
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");
	}
		
	@Test
	public void testAdyenAuthorise() {
		String userCredentials = username +":" + password ;
		String basicAuth = "Basic " +  new String(Base64.getEncoder().encode(userCredentials.getBytes()));

		System.out.println("basicAuth=====" + basicAuth);
		
		headers = new HttpHeaders();        //
        headers.add("Content-Type", "application/json");
		headers.add("Authorization", basicAuth);

        AdyenDirectCard card=new AdyenDirectCard();
        card.setNumber("5101180000000007");
        card.setExpiryMonth("03");
        card.setExpiryYear("2030");
        card.setCvc("737");
        card.setHolderName("test myne");
        
        AdyenDirectAmount amount=new AdyenDirectAmount();
        amount.setCurrency("EUR");
        amount.setValue(1200);
        
        AdyenDirectAuthoriseRequest authoriseRequest=new AdyenDirectAuthoriseRequest();
        authoriseRequest.setAmount(amount);
        authoriseRequest.setCard(card);
        authoriseRequest.setMerchantAccount(merchangeAccount);
        authoriseRequest.setReference("payment-0111133");
        
        ObjectMapper om = new ObjectMapper();
        
        SSLContext context = null;
		try {
			context = SSLContext.getInstance(tlsVersion);
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
			context.init(null, null, null);
		} catch (KeyManagementException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        CloseableHttpClient httpClient = HttpClientBuilder.create().setSSLContext(context)
            .build();
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
        
        restTemplate=new RestTemplate(factory);
        String jsonBody = "";
        
        try {
			jsonBody=om.writeValueAsString(authoriseRequest);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("request auth=====" + jsonBody);
        
        HttpEntity<String> entity = new HttpEntity<String>(jsonBody, headers);
         
        responseEntity = restTemplate.postForEntity(authtUrl, entity, String.class);
        
       // String responseBodyPOST = responseEntity.getBody();
        
        responseBody = responseEntity.getBody().toString();
        System.out.println("responseBody --->" + responseBody);
		
	}

}
