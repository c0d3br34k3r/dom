package com.catascopic.dominion.zone;

import com.catascopic.dominion.Card;
import com.google.common.base.Predicate;

public abstract class Zone {

	public abstract Locator selectAll();

	public abstract Locator selectIf(Predicate<Card> filter);

}
