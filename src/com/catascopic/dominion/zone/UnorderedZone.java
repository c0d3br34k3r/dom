package com.catascopic.dominion.zone;

import java.util.Collections;
import java.util.Set;

import com.catascopic.dominion.Card;

public class UnorderedZone extends Zone {

	private Set<Card> cards;

	@Override
	public Set<Card> cards() {
		return Collections.unmodifiableSet(cards);
	}

	@Override
	public void accept(Selection selection) {
		cards.addAll(selection.remove());
	}

	@Override
	Locator getLocator(final Card card) {
		return new Locator(card) {

			@Override
			public boolean remove(Zone zone) {
				if (tracking()) {
					move(zone);
				}
			}
		};
	}

}
