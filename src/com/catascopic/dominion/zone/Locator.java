package com.catascopic.dominion.zone;

import java.util.Collection;

import com.catascopic.dominion.Card;

interface Locator {

	abstract void remove(Collection<Card> cards);

}
