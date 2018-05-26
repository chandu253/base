package com.mtml.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Game implements Serializable {
	protected int gameNo;
	protected String name;
	protected String type;
	protected Date conductedDate;
	protected List<Player> players;

	public int getGameNo() {
		return gameNo;
	}

	public void setGameNo(int gameNo) {
		this.gameNo = gameNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getConductedDate() {
		return conductedDate;
	}

	public void setConductedDate(Date conductedDate) {
		this.conductedDate = conductedDate;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conductedDate == null) ? 0 : conductedDate.hashCode());
		result = prime * result + gameNo;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if (conductedDate == null) {
			if (other.conductedDate != null)
				return false;
		} else if (!conductedDate.equals(other.conductedDate))
			return false;
		if (gameNo != other.gameNo)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Game [gameNo=" + gameNo + ", name=" + name + ", type=" + type + ", conductedDate=" + conductedDate
				+ ", players=" + players + "]";
	}

}
