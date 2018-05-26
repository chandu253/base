package com.freecharge.airtel.agent.factory;

import com.freecharge.agent.DTHRechargeAgent;
import com.freecharge.agent.MobileRechargeAgent;
import com.freecharge.agent.factory.AbstractAgentFactory;
import com.freecharge.airtel.agent.AirtelDTHRechargeAgent;
import com.freecharge.airtel.agent.AirtelMobileRechargeAgent;

public class AirtelAgentFactory extends AbstractAgentFactory {

	@Override
	protected MobileRechargeAgent createMobileRechargeAgent() {
		return new AirtelMobileRechargeAgent();
	}

	@Override
	protected DTHRechargeAgent createDTHRechargeAgent() {
		return new AirtelDTHRechargeAgent();
	}

}
