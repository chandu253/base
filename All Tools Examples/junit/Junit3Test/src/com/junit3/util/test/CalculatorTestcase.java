package com.junit3.util.test;

import com.junit3.util.Calculator;

import junit.framework.Assert;
import junit.framework.TestCase;

public class CalculatorTestcase extends TestCase {
	public void testAdd() {
		int a = 10;
		int b = 20;
		int expectedSum = 30;
		int actualSum = 0;
		Calculator calculator = null;
		
		calculator = new Calculator();
		actualSum = calculator.add(a, b);
		Assert.assertEquals(expectedSum, actualSum);
	}
}













