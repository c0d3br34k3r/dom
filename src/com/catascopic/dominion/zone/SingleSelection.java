package com.catascopic.dominion.zone;

import java.util.Collections;
import java.util.List;

import com.catascopic.dominion.Card;

public abstract class SingleSelection extends Selection {

	static final SingleSelection EMPTY = new SingleSelection() {

		@Override
		List<Card> remove() {
			return Collections.emptyList();
		}
	};

	static SingleSelection of(final Card card, final Locator locator) {
		return new SingleSelection() {

			@Override
			List<Card> remove() {
				return locator.remove()
						? Collections.singletonList(card)
						: Collections.<Card>emptyList();
			}
		};
	}

}
