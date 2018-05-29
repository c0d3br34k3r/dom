package com.catascopic.dominion.modify;

import com.catascopic.dominion.Card;

public abstract class CardValue<E> implements Value<E> {

	private final Card card;

	public CardValue(Card card) {
		this.card = card;
	}

	public Card card() {
		return card;
	}

}
