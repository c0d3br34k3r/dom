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

	public void moveToTop(SingleSelection selection) {
		if (selection.remove()) {
			cards.add(selection.get());
			topCount++;
		}
	}

	public void shuffle() {
		Collections.shuffle(cards);
		topCount++;
	}

	public SingleSelection selectTop() {
		if (ensureSize(1)) {
			final Card top = cards.get(cards.size() - 1);
			final int currentMoveCount = top.location().moveCount();
			final int currentTopCount = topCount;
			return SingleSelection.of(top, new Locator() {

				@Override
				public boolean remove() {
					if (currentMoveCount == top.location().moveCount()
							&& currentTopCount == topCount) {
						cards.remove(cards.size() - 1);
						return true;
					}
					return false;
				}
			});
		}
		return SingleSelection.EMPTY;
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
