package com.freecharge.agent;

public interface MobileRechargeAgent {
	boolean recharge(String mobile, String pkg, float amount);
}
