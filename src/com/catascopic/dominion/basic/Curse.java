package com.catascopic.dominion.basic;

import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Deck;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Type;

class Curse extends Identity {

	Curse() {
		super(Name.CURSE, 0, Type.CURSE);
	}

	@Override
	public int value(Deck deck) {
		return -1;
	}

}
