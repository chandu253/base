package com.st.util;

public class ArrayUtil {

	public int getHighestNumber(int[] inArray) {
		int highest = 0;

		for (int i = 0; i < inArray.length; i++) {
			if (i == 0) {
				highest = inArray[i];
			}
			if (highest < inArray[i]) {
				highest = inArray[i];
			}
		}
		return highest;
	}
}
