package com.catascopic.dominion.zone;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.catascopic.dominion.Card;
import com.catascopic.dominion.Player;

public class Deck extends Zone {

	private List<Card> cards = new ArrayList<>();
	private Player player;
	private int topCount;

	public void moveToTop(Selection selection) {
		if (cards.addAll(selection.remove())) {
			topCount++;
		}
	}

	public void shuffle() {
		Collections.shuffle(cards);
		topCount++;
	}

	public SingleSelection selectTop() {
		if (ensureSize(1)) {

		}
		return Selection.EMPTY;
	}

	private boolean ensureSize(int amount) {
		if (cards.size() < amount) {
			dump(player.discardPile());
		}
		shuffle();
		return cards.size() >= amount;
	}

	@Override
	void dump(Zone zone) {
		cards.addAll(zone.removeAll());
	}

	@Override
	Collection<Card> removeAll() {
		for (Card card : cards) {
			card.location().move();
		}
		Collection<Card> result = new ArrayList<>(cards);
		cards.clear();
		return result;
	}

}
