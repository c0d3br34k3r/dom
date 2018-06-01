package com.catascopic.dominion.basic;

import com.catascopic.dominion.Identity;
import com.catascopic.dominion.CombinedDeck;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Type;

class Estate extends Identity {

	Estate() {
		super(Name.ESTATE, 2, Type.VICTORY);
	}

	@Override
	public int value(CombinedDeck deck) {
		return 1;
	}

}
