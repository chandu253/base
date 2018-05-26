package com.dn.annon;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("cacheManager")
public class LoanCalculator {

	public LoanCalculator() {
		System.out.println("Reading data from cache in loadCalculator");
	}

	public double calculate(long principle, int tenure, String city) {
		return 3535.34;
	}
}
