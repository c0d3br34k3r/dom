package com.catascopic.dominion.zone;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.catascopic.dominion.Card;

public class UnorderedZone extends Zone {

	private Set<Card> cards;

	public Set<Card> cards() {
		return Collections.unmodifiableSet(cards);
	}

	@Override
	Collection<Card> removeAll() {
		List<Card> contents = new ArrayList<>(cards);
		for (Card card : cards) {
			card.location().move();
		}
		cards.clear();
		return contents;
	}

	public void dump(Zone zone) {
		cards.addAll(zone.removeAll());
	}

	public Selection accept(Selection selection) {
		Collection<Card> removed = selection.remove();
		cards.addAll(removed);
		Collection<Locator> locators = getLocators(removed);
		return new Selection() {

			@Override
			Collection<Card> remove() {
				for (Locator locator : locators) {
					locator.remove(dest)
				}
			}
		};
	}

	private Collection<Locator> getLocators(Collection<Card> removed) {
		return null;
	}

	Locator getLocator(final Card card) {
		final int moveCount = card.location().moveCount();
		new Locator() {

			@Override
			public boolean remove() {
				if (moveCount == card.location().moveCount()) {
					cards.remove(card);
					dest.add(card);
				}
			}
		};
	}

}
