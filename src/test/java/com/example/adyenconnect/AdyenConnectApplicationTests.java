package com.example.adyenconnect;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.net.ssl.SSLContext;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
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
class AdyenConnectApplicationTests {

	/*@Test
	void contextLoads() {
	}
	*/
	
	RestTemplate restTemplate;
	private HttpHeaders headers;
	private String checkoutUrl="https://checkout-test.adyen.com/v52/paymentMethods";
	private String authtUrl="https://pal-test.adyen.com/pal/servlet/Payment/v52/authorise";
	private ResponseEntity<String> responseEntity;
	private String responseBody;
	
	
	@BeforeMethod
	public void initializeMethods() {
		headers = new HttpHeaders();        
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");
	}
	
	
/*	@Test
	public void testAdyenPaymentMethods() {
		
		headers = new HttpHeaders();        
        headers.add("Content-Type", "application/json");
        headers.add("x-api-key", "AQEphmfuXNWTK0Qc+iSEl3cshueYR55DGcYbDjZsj36Fk12Sn09giHs3xmEQwV1bDb7kfNy1WIxIIkxgBw==-kAQnuCL3u9vTU4m5SpxqinvPT/uiI/QuZCdYzpxD1Vo=-Es^Vf2~)8QjK_2,p");
        
       
        PayMethods methods=new PayMethods();
        methods.setMerchantAccount("TestAccount516POS");
        
        ObjectMapper om = new ObjectMapper();
        
        restTemplate=new RestTemplate();
        String jsonBody = "";
        
        try {
			jsonBody=om.writeValueAsString(methods);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("request=====");
        System.out.println("\n\n" + jsonBody);
        
        HttpEntity<String> entity = new HttpEntity<String>(jsonBody, headers);
         
        responseEntity = restTemplate.postForEntity(checkoutUrl, entity, String.class);
          
        responseBody = responseEntity.getBody().toString();
        System.out.println("responseBody --->" + responseBody);
	}*/
	
	/*@Test
	public void testAdyenAuthorise() {
		String userCredentials = "ws@Company.TestAccount516:8.,3JV4ImvEux@>tQ9HD}q58q";
		String basicAuth = "Basic " +  new String(Base64.getEncoder().encode(userCredentials.getBytes()));

		System.out.println("basicAuth=====" + basicAuth);
		
		headers = new HttpHeaders();        //
        headers.add("Content-Type", "application/json");
		headers.add("Authorization", basicAuth);
       // headers.setBasicAuth(basicAuth);

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
        authoriseRequest.setMerchantAccount("TestAccount516ECOM");
        authoriseRequest.setReference("payment-0111133");
        
        ObjectMapper om = new ObjectMapper();
        
        SSLContext context = null;
		try {
			context = SSLContext.getInstance("TLSv1.2");
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
		
	}*/

}
