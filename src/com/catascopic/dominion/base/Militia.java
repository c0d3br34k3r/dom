package com.catascopic.dominion.base;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Filters;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Prompt;
import com.catascopic.dominion.Type;

class Militia extends Identity {

	Militia() {
		super(Name.MILITIA, 4, Type.ACTION, Type.ATTACK);
	}

	@Override
	public void play(Player player, Activation activation) {
		player.addCoins(2, activation);
		for (Player opponent : player.getAttacks(activation)) {
			opponent.discard(activation, opponent.selectExactly(
					opponent.hand(),
					opponent.hand().size(),
					Filters.ANY, Prompt.get(this)));
		}
	}

}
