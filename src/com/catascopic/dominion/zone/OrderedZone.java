package com.catascopic.dominion.zone;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.catascopic.dominion.Card;

public class OrderedZone extends Zone {

	private List<Card> cards;
	private int topCount;

	@Override
	public List<Card> cards() {
		return Collections.unmodifiableList(cards);
	}

	public void accept(Selection selection) {
		Set<Card> removed = selection.remove();
		cards.addAll(removed);
		for (Card card : cards) {
			card.location().move(this);
		}
	}

	public void shuffle() {
		Collections.shuffle(cards);
		topCount++;
	}

}
