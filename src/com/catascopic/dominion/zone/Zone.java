package com.catascopic.dominion.zone;

import java.util.Collection;

import com.catascopic.dominion.Card;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

public abstract class Zone {

	public Selection selectAll() {
		return new Selection(this, toLocators(cards()));
	}

	public Selection selectIf(Predicate<Card> filter) {
		return new Selection(this, Collections2.filter(cards(), filter));
	}

	public abstract Collection<Card> cards();

}
