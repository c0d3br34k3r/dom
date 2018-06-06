package com.catascopic.dominion.zone;

import java.util.Collection;

import com.catascopic.dominion.Card;
import com.google.common.collect.Iterables;

public class SingleSelection extends Selection {

	SingleSelection(Locator locator) {
		super(locator);
	}

	public Card get() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	static abstract class SingleAcceptor implements Acceptor {

		abstract Locator accept(Card removed);

		@Override
		public Locator accept(Collection<Card> removed) {
			return accept(Iterables.getOnlyElement(removed));
		}
	}

}
