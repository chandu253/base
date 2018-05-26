package com.pac.beans;

public class Toy {
	private int id;
	private String toyName;
	private Remote remote;

	public void setId(int id) {
		this.id = id;
	}

	public void setToyName(String toyName) {
		this.toyName = toyName;
	}

	public void setRemote(Remote remote) {
		this.remote = remote;
	}

	@Override
	public String toString() {
		return "Toy [id=" + id + ", toyName=" + toyName + ", remote=" + remote + "]";
	}

}
