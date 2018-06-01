package com.catascopic.dominion.zone;

import java.util.Collection;
import java.util.Collections;

import com.catascopic.dominion.Card;
import com.catascopic.dominion.experimental.OptionalSet;

public abstract class Selection {

	private List<Locator>
	
	abstract Collection<Card> remove();

	public Collection<Card> cards() {
		// TODO Auto-generated method stub
		return null;
	}

	static final SingleSelection EMPTY = new SingleSelection() {

		@Override
		Collection<Card> remove() {
			return Collections.emptySet();
		}

		@Override
		public OptionalSet<Card> cards() {
			return OptionalSet.empty();
		}
	};

}
