package com.catascopic.dominion.base;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Type;

class Festival extends Identity {

	Festival() {
		super(Name.FESTIVAL, 5, Type.ACTION);
	}

	@Override
	public void play(Player player, Activation activation) {
		player.addActions(2, activation);
		player.addBuy(activation);
		player.addCoins(2, activation);
	}

}
