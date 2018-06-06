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

	Locator locator;

	Selection(Locator locator) {
		this.locator = locator;
	}

	Collection<Card> move(Acceptor acceptor) {
		List<Card> removed = new ArrayList<>();
		locator.remove(removed);
		if (!removed.isEmpty()) {
			locator = acceptor.accept(removed);
		}
		return removed;
	}

	interface Acceptor {

		Locator accept(Collection<Card> removed);
	}

}
