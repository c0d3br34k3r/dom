package com.catascopic.dominion.basic;

import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Deck;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Type;

class Duchy extends Identity {

	Duchy() {
		super(Name.DUCHY, 5, Type.VICTORY);
	}

	@Override
	public int value(Deck deck) {
		return 3;
	}

}
