package com.client.test;

import com.client.dto.MatchInnings;
import com.client.invoker.ScoreBoard;

public class ScoreBoardTest {
	public static void main(String[] args) {
		ScoreBoard sBoard = new ScoreBoard("m19", 2);
		MatchInnings mi = sBoard.getInnings();
		System.out.println(mi.getMatchName());
	}

}
