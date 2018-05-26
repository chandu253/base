package com.freecharge.vodafone.agent;

import com.freecharge.agent.MobileRechargeAgent;

public class VodafoneMobileRechargeAgent implements MobileRechargeAgent {
	@Override
	public boolean recharge(String mobile, String pkg, float amount) {
		System.out.println("recharge vodafone mobile : " + mobile + " with amount : " + amount);
		return true;
	}

}
