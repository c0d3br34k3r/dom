package com.catascopic.dominion.basic;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Type;

class Silver extends Identity {

	Silver() {
		super(Name.SILVER, 0, Type.TREASURE);
	}

	@Override
	public void play(Player player, Activation activation) {
		player.addCoins(2, activation);
	}

}
