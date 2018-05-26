package com.freecharge.store;

import javax.annotation.processing.AbstractProcessor;

import com.freecharge.agent.MobileRechargeAgent;
import com.freecharge.agent.factory.AbstractAgentFactory;
import com.freecharge.factory.FreechargeFactory;

public class FreechargeStore {
	public boolean rechargeMobile(String provider, String mobile, String pkg, float amount) {
		AbstractAgentFactory agentFactory = null;
		MobileRechargeAgent rechargeAgent = null;
		boolean flag = false;

		agentFactory = FreechargeFactory.newAgentFactory(provider);
		rechargeAgent = agentFactory.newMobileRechargeAgent();
		flag = rechargeAgent.recharge(mobile, pkg, amount);
		return flag;
	}
}
