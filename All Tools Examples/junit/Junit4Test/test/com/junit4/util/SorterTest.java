package com.junit4.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SorterTest {
	private int[] inPosArray;
	private int[] inNevArray;
	private int[] expectedPosArray;
	private int[] expectedNevArray;
	private Sorter sorter;

	@Before
	public void init() {
		inPosArray = new int[] { 10, 1, 0, 3, 2 };
		expectedPosArray = new int[] { 0, 1, 2, 3, 10 };
		inNevArray = new int[] { -4, -11, -10, -1, -2 };
		expectedNevArray = new int[] { -11, -10, -4, -2, -1 };
		sorter = new Sorter();
	}

	@Test
	public void testSortWithPosNumbers() {
		int[] actualPostNumbers = null;

		actualPostNumbers = sorter.sort(inPosArray);
		Assert.assertArrayEquals(expectedPosArray, actualPostNumbers);
	}

	@Test
	public void testSortWithNevNumbers() {
		int[] actualNevNumbers = null;

		actualNevNumbers = sorter.sort(inNevArray);
		Assert.assertArrayEquals(expectedNevArray, actualNevNumbers);
	}

	@After
	public void cleaup() {
		sorter = null;
	}
}
