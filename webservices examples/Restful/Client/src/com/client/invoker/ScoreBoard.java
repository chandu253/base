package com.client.invoker;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

import com.client.dto.MatchInnings;

public class ScoreBoard {
	protected final String SCORE_BOARD_URI = "http://localhost:8081/Icc/info/score";
	protected String matchNo;
	protected int innings;
	protected Invocation getInningsInvocation;

	public ScoreBoard(String matchNo, int innings) {
		this.matchNo = matchNo;
		this.innings = innings;

		getInningsInvocation = ClientBuilder.newClient().target(SCORE_BOARD_URI).path("/innings").path(matchNo)
				.path(String.valueOf(innings)).request().buildGet();
	}

	public MatchInnings getInnings() {
		Response response = null;
		MatchInnings matchInnings = null;

		response = getInningsInvocation.invoke();
		if (response.getStatus() == 200) {
			matchInnings = response.readEntity(MatchInnings.class);
		}

		return matchInnings;
	}
}
