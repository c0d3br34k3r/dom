package com.catascopic.dominion.base;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.PileName;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Type;

class Witch extends Identity {

	Witch() {
		super(Name.WITCH, 5, Type.ACTION, Type.ATTACK);
	}

	@Override
	public void play(Player player, Activation activation) {
		player.draw(2, activation);
		for (Player opponent : player.getAttacks(activation)) {
			opponent.gain(activation, PileName.CURSE);
		}
	}

}
