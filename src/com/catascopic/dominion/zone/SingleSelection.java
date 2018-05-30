package com.catascopic.dominion.zone;

import com.catascopic.dominion.Card;
import com.catascopic.dominion.experimental.OptionalSet;
import com.google.common.collect.Iterables;

public abstract class SingleSelection extends Selection {

	@Override
	public abstract OptionalSet<Card> cards();

	public boolean isEmpty() {
		return cards().isEmpty();
	}

	public Card get() {
		return Iterables.getOnlyElement(cards());
	}

}
