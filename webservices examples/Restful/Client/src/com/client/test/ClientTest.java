package com.client.test;

import com.client.invoker.MerchantInvoker;

public class ClientTest {
	public static void main(String[] args) {
		MerchantInvoker merchantInvoker = null;
		
		merchantInvoker = new MerchantInvoker();
		String address = merchantInvoker.invokeGetMerchantAddress("flipkart");
		System.out.println(address);
	}
}
