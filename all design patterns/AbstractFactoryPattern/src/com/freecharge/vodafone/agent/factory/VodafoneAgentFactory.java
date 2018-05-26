package com.freecharge.vodafone.agent.factory;

import com.freecharge.agent.DTHRechargeAgent;
import com.freecharge.agent.MobileRechargeAgent;
import com.freecharge.agent.factory.AbstractAgentFactory;
import com.freecharge.vodafone.agent.VodafoneDTHRechargeAgent;
import com.freecharge.vodafone.agent.VodafoneMobileRechargeAgent;

public class VodafoneAgentFactory extends AbstractAgentFactory {

	@Override
	protected MobileRechargeAgent createMobileRechargeAgent() {
		return new VodafoneMobileRechargeAgent();
	}

	@Override
	protected DTHRechargeAgent createDTHRechargeAgent() {
		return new VodafoneDTHRechargeAgent();
	}

}
