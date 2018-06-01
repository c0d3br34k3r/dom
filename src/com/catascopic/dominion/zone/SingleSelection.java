package com.catascopic.dominion.zone;

import java.util.Collection;

import com.catascopic.dominion.Card;
import com.catascopic.dominion.experimental.OptionalSet;
import com.google.common.collect.Iterables;

public class SingleSelection extends Selection {

	private OptionalSet<Locator> locator;

	public boolean isEmpty() {
		return locator.isEmpty();
	}

	public Card get() {
		return locator.getOnly().card();
	}

	@Override
	OptionalSet<Card> remove() {
		if (!locator.isEmpty()) {
			return locator.getOnly().remove();
		}
		return false;
	}

}
