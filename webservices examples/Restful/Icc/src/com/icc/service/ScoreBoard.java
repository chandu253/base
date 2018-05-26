package com.icc.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.icc.dto.Innings;

@Path("/score")
public class ScoreBoard {
	@Path("/innings/{matchNo}/{innings}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Innings getInnings(@PathParam("matchNo") String matchNo, @PathParam("innings") int inningsNo) {
		Innings innings = null;

		innings = new Innings();
		innings.setMatchName(matchNo + "Match");
		innings.setTeam1("India");
		innings.setTeam2("South Africa");
		innings.setMatchType("Test");

		return innings;
	}
}
