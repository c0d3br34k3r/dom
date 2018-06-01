package com.catascopic.dominion.basic;

import com.catascopic.dominion.Identity;
import com.catascopic.dominion.CombinedDeck;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Type;

class Province extends Identity {

	Province() {
		super(Name.PROVINCE, 8, Type.VICTORY);
	}

	@Override
	public int value(CombinedDeck deck) {
		return 6;
	}

}
