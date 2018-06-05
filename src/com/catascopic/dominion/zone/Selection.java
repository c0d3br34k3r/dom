package com.catascopic.dominion.zone;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.catascopic.dominion.Card;

public class Selection {

	static final Locator EMPTY_LOCATOR = new Locator() {

		@Override
		public void remove(Collection<Card> cards) {}
	};

	public static SingleSelection empty() {
		return new SingleSelection(EMPTY_LOCATOR);
	}

	private Locator locator;
	private Collection<Card> cards; // = null

	Selection(Locator locator) {
		this.locator = locator;
	}

	void move(Acceptor acceptor) {
		List<Card> removed = new ArrayList<>();
		locator.remove(removed);
		if (!removed.isEmpty()) {
			locator = acceptor.accept(removed);
		}
		cards = removed;
	}

	public Collection<Card> cards() {
		if (cards == null) {
			throw new IllegalStateException();
		}
		return cards;
	}

	interface Acceptor {

		Locator accept(Collection<Card> removed);
	}

}
