package com.freecharge.airtel.agent;

import com.freecharge.agent.DTHRechargeAgent;

public class AirtelDTHRechargeAgent implements DTHRechargeAgent {

	@Override
	public float rechargePackage(String accountNo, String pkg, float amount) {
		System.out.println("dth recharge for account : " + accountNo + " with package : " + pkg);
		return amount;
	}

}
