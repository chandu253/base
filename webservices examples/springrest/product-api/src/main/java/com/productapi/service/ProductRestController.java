package com.productapi.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.productapi.dto.Product;

@RestController
@RequestMapping("/product")
public class ProductRestController {

	@RequestMapping(method = RequestMethod.GET, value = "/{productNo}", produces = "text/plain")
	public String getProductName(@PathVariable("productNo") String productNo) {
		return "Microwave";
	}

	@RequestMapping(value = "/details/{productNo}", method = RequestMethod.GET, produces = "application/json")
	public Product getProductDetails(@PathVariable("productNo") String productNo) {
		Product product = null;

		product = new Product();
		product.setProductNo(productNo);
		product.setProductName("Television");
		product.setManufacturer("Samsung");
		product.setPrice(35353.34f);
		return product;
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> addProduct(@RequestBody Product product) {
		ResponseEntity<String> responseEntity = null;

		responseEntity = new ResponseEntity<String>("Your product : " + product.getProductName() + " has been added",
				HttpStatus.CREATED);
		return responseEntity;
	}

}










