package com.catascopic.dominion.base;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.PileName;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Type;

class Bandit extends Identity {

	Bandit() {
		super(Name.BANDIT, 5, Type.ACTION, Type.ATTACK);
	}

	@Override
	public void play(Player player, Activation activation) {
		player.gain(activation, PileName.GOLD);
		for (Player opponent : player.getAttacks(activation)) {
			// TODO: reveal
		}
	}

}
