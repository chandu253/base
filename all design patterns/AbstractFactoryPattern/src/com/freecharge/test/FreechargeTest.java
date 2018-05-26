package com.freecharge.test;

import com.freecharge.store.FreechargeStore;

public class FreechargeTest {
	public static void main(String[] args) {
		FreechargeStore fcs = new FreechargeStore();
		fcs.rechargeMobile("vodafone", "93849485", "449-plan", 449);
	}
}
