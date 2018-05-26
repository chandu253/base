package com.productapi.client;

import org.springframework.web.client.RestTemplate;

public class ProductClient {
	public static void main(String[] args) {
		RestTemplate restTemplate = null;

		restTemplate = new RestTemplate();
		String productName = restTemplate.getForObject("http://localhost:8081/product-api/product/p39", String.class);
		System.out.println(productName);

	}
}
