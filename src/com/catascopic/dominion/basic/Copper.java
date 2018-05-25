package com.catascopic.dominion.basic;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Type;

class Copper extends Identity {

	Copper() {
		super(Name.COPPER, 0, Type.TREASURE);
	}

	@Override
	public void play(Player player, Activation activation) {
		player.addCoins(1, activation);
	}

}
