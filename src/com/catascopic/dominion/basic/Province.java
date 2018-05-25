package com.catascopic.dominion.basic;

import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Deck;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Type;

class Province extends Identity {

	Province() {
		super(Name.PROVINCE, 8, Type.VICTORY);
	}

	@Override
	public int value(Deck deck) {
		return 6;
	}

}
