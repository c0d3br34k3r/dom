package com.catascopic.dominion.zone;

public class Location {

	private int moveCount;
	private Zone zone;

	int moveCount() {
		return moveCount;
	}

	int move(Zone zone) {
		this.zone = zone;
		return ++moveCount;
	}

}
