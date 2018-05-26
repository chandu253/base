package com.freecharge.airtel.agent;

import com.freecharge.agent.MobileRechargeAgent;

public class AirtelMobileRechargeAgent implements MobileRechargeAgent {

	@Override
	public boolean recharge(String mobile, String pkg, float amount) {
		System.out.println("recharging airtel mobile : " + mobile + " with amount : " + amount);
		return true;
	}

}
