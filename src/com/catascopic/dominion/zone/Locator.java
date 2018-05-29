package com.catascopic.dominion.zone;

import com.catascopic.dominion.Card;

abstract class Locator {

	private final Card card;
	private int moveCount;

	Locator(Card card) {
		this.card = card;
		this.moveCount = card.location().moveCount();
	}

	abstract boolean remove(Zone zone);

	boolean tracking() {
		return moveCount == card.location().moveCount();
	}

	void move(Zone zone) {
		this.moveCount = card.location().move(zone);
	}

	Card card() {
		return card;
	}

}
