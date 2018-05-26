package com.don.beans;

import java.util.Properties;

public class LoanPlanner {
	private Cache cache;

	public void calculate(long principle, int tenure, String place) throws Exception {
		Properties props = null;
		double interestRate = 0;
		double interestAmount = 0;

		props = (Properties) cache.get("p-ri");
		if (props.containsKey(place) == false) {
			throw new Exception("place is not supported");
		}
		interestRate = Double.parseDouble(props.getProperty(place));
		interestAmount = (principle * tenure * interestRate) / 100;
		System.out.println("Interest Amount to be paid : " + interestAmount);
	}

	public void setCache(Cache cache) {
		this.cache = cache;
	}

}
