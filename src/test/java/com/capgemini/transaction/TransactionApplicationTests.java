package com.capgemini.transaction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TransactionApplicationTests {

	@LocalServerPort
	private int port;

	private TestRestTemplate restTemplate;
	private static HttpHeaders headers;
	private StringBuilder transactionControllerURL = new StringBuilder();
	@Mock
	private RestTemplate mockRestTemplate;
	String url;
	@BeforeEach
	void setUp() throws IOException {
		restTemplate = new TestRestTemplate();
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		url = "http://localhost:" + port + "/api/v1/transactions/";

	}

	//http://localhost:8087/api/v1/transactions?accountNumber=sfdsfdsf&pageNo=0&pageSize=1
	//http://localhost:8087/api/v1/transactions/DEBIT?accountNumber=sfdsfdsf&amount=20&custId=sadlksd&description=ajdljkkja&transactionTime=2021-07-15T15%3A12%3A19.275Z
	@Test
	public void createTransactionHappyFlow() {
		HttpEntity<String> request = new HttpEntity<>( headers);
		transactionControllerURL.append(url);
		transactionControllerURL.append("DEBIT?accountNumber=accNumber&amount=20&custId=cust1&description=testing&transactionTime=");
		transactionControllerURL.append(LocalDateTime.now());
		ResponseEntity<String> transactioPostResponse = this.restTemplate.exchange(transactionControllerURL.toString(), HttpMethod.POST, request, String.class);
		assertEquals(transactioPostResponse.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void getTransactionHappyFlow() {
		HttpEntity<String> request = new HttpEntity<>( headers);
		transactionControllerURL.append(url);
		transactionControllerURL.append("DEBIT?accountNumber=accNumber&amount=20&custId=cust1&description=testing&transactionTime=");
		transactionControllerURL.append(LocalDateTime.now());
		this.restTemplate.exchange(transactionControllerURL.toString(), HttpMethod.POST, request, String.class);
		transactionControllerURL = new StringBuilder();
		transactionControllerURL.append(url);
		transactionControllerURL.append("?accountNumber=accNumber&pageNo=0&pageSize=1");
		ResponseEntity<String>  transactioGetResponse = this.restTemplate.exchange(transactionControllerURL.toString(), HttpMethod.GET, request, String.class);
		assertEquals(transactioGetResponse.getStatusCode(), HttpStatus.OK);
	}
}
