package com.catascopic.dominion.zone;

import java.util.Collection;

import com.catascopic.dominion.Card;

public interface Selectable {

	Collection<Card> cards();
	
	SingleSelection select(Card card);

	Selection select(Collection<Card> cards);
	
	Selection selectAll();

}
