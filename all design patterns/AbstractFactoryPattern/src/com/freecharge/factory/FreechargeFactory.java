package com.freecharge.factory;

import com.freecharge.agent.factory.AbstractAgentFactory;
import com.freecharge.airtel.agent.factory.AirtelAgentFactory;
import com.freecharge.vodafone.agent.factory.VodafoneAgentFactory;

// abstract factory (factory of factories)
public class FreechargeFactory {
	public static AbstractAgentFactory newAgentFactory(String provider) {
		AbstractAgentFactory agentFactory = null;

		if (provider.equals("airtel")) {
			agentFactory = new AirtelAgentFactory();
		} else if (provider.equals("vodafone")) {
			agentFactory = new VodafoneAgentFactory();
		}

		return agentFactory;
	}
}
