package com.catascopic.dominion.zone;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.catascopic.dominion.Card;

public class DiscardPile extends OrderedZone implements Selectable {

	public Card topCard() {
		return contents.get(0);
	}

	Collection<Card> recycle() {
		ArrayList<Card> removed = new ArrayList<>(contents);
		contents.clear();
		for (Card card : removed) {
			card.location().move();
		}
		Collections.shuffle(removed);
		topCount++;
		return removed;
	}

	@Override
	public Collection<Card> cards() {
		return contents;
	}

	@Override
	public SingleSelection select(Card card) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Selection select(Collection<Card> cards) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Selection selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
