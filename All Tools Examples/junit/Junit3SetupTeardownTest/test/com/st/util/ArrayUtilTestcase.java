package com.st.util;

import junit.framework.Assert;
import junit.framework.TestCase;

public class ArrayUtilTestcase extends TestCase {
	private int[] posInArray;
	private int[] nevInArray;
	private int expectedPosHighestNumber;
	private int expectedNevHighestNubmer;
	private ArrayUtil arrayUtil;

	@Override
	protected void setUp() throws Exception {
		posInArray = new int[] { 10, 20, 0, 30, 100 };
		nevInArray = new int[] { -10, -20, -1, -100 };
		expectedPosHighestNumber = 100;
		expectedNevHighestNubmer = -1;
		arrayUtil = new ArrayUtil();
		System.out.println("setUp()");
	}

	public void testGetHighestNumberWithPositiveNumbers() {
		int actualHighestNumber = 0;

		actualHighestNumber = arrayUtil.getHighestNumber(posInArray);
		Assert.assertEquals(expectedPosHighestNumber, actualHighestNumber);
	}

	public void testGetHighestNumberWithNegativeNumbers() {
		int actualNevHighestNumber = -1;

		actualNevHighestNumber = arrayUtil.getHighestNumber(nevInArray);
		Assert.assertEquals(expectedNevHighestNubmer, actualNevHighestNumber);
	}

	@Override
	protected void tearDown() throws Exception {
		System.out.println("tearDown()");
		arrayUtil = null;
	}

}
