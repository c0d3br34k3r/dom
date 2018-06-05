package com.catascopic.dominion.base;

import com.catascopic.dominion.CombinedDeck;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Type;

class Gardens extends Identity {

	Gardens() {
		super(Name.GARDENS, 4, Type.VICTORY);
	}

	@Override
	public int value(CombinedDeck deck) {
		return deck.size() / 10;
	}

}
