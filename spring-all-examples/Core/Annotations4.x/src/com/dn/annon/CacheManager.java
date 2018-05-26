package com.dn.annon;

import org.springframework.stereotype.Component;

@Component
public class CacheManager {
	public CacheManager() {
		System.out.println("loading data into cache");
	}
}
