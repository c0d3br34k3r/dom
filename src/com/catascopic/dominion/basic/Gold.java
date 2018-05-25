package com.catascopic.dominion.basic;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Type;

class Gold extends Identity {

	Gold() {
		super(Name.GOLD, 6, Type.TREASURE);
	}

	@Override
	public void play(Player player, Activation activation) {
		player.addCoins(3, activation);
	}

}
