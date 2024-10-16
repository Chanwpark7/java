package com.clsex;

public class GameAccount {
	private String ID;
	private String PW;
	private int win;
	private int lose;
	private int draw;
	private int total;
	

	public String getID() {
		return ID;
	}

	public String getPW() {
		return PW;
	}

	public String toString() {
		return "GameAccount [ID=" + ID + ", PW=" + PW + "]";
	}
	
	public GameAccount(String ID, String PW) {
		this.ID = ID;
		this.PW = PW;
	}
}
