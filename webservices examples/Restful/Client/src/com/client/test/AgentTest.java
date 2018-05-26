package com.client.test;

import com.client.invoker.Agent;

public class AgentTest {
	public static void main(String[] args) {
		Agent agent = new Agent();
		/*String searchResult = agent.search("hyderabad", "apartment", "sr nagar", 200, 393808, 9383494);
		System.out.println(searchResult);*/
		/*String message = agent.unlistProperty("hyderabad", "p293", "ag93");
		System.out.println(message);*/
		String message = agent.addAmenity("hyderabad", "lift", "p38");
		System.out.println(message);
	}
}
