package com.junit4.util;

public class ArrayUtil {
	public int[] reverse(int[] in) {
		int[] reverse = null;
		int j = 0;

		reverse = new int[in.length];
		for (int i = in.length - 1; i >= 0; i--) {
			reverse[j++] = in[i];
		}
		return reverse;
	}
}
