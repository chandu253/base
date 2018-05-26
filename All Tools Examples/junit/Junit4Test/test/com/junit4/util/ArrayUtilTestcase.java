package com.junit4.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayUtilTestcase {
	private int[] inArray;
	private int[] expectedArray;
	private ArrayUtil arrayUtil;

	@Before
	public void init() {
		inArray = new int[] { 1, 2, 3, 4, 5 };
		expectedArray = new int[] { 5, 4, 3, 2, 1 };
		arrayUtil = new ArrayUtil();
	}

	@Test
	public void testReverse() {
		int[] actualArray = null;

		actualArray = arrayUtil.reverse(inArray);
		Assert.assertArrayEquals(expectedArray, actualArray);
	}

	@After
	public void clean() {
		arrayUtil = null;
	}
}
