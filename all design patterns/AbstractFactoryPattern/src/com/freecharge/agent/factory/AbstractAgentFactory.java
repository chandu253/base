package com.freecharge.agent.factory;

import com.freecharge.agent.DTHRechargeAgent;
import com.freecharge.agent.MobileRechargeAgent;

// factory method pattern
public abstract class AbstractAgentFactory {
	// factory method for MobileRechargeAgent component interface
	public MobileRechargeAgent newMobileRechargeAgent() {
		MobileRechargeAgent mobileRechargeAgent = null;

		mobileRechargeAgent = createMobileRechargeAgent();
		// standard instantiation process
		return mobileRechargeAgent;
	}

	public DTHRechargeAgent newDTHRechargeAgent() {
		DTHRechargeAgent dthRechargeAgent = null;

		dthRechargeAgent = createDTHRechargeAgent();
		return dthRechargeAgent;
	}

	protected abstract MobileRechargeAgent createMobileRechargeAgent();
	protected abstract DTHRechargeAgent createDTHRechargeAgent();
}
