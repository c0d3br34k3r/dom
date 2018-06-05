package com.catascopic.dominion.base;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Filters;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Prompt;
import com.catascopic.dominion.Type;

class Moneylender extends Identity {

	Moneylender() {
		super(Name.MONEYLENDER, 4, Type.ACTION);
	}

	@Override
	public void play(Player player, Activation activation) {
		if (player.trash(activation, player.maySelectOne(
				player.hand(),
				Filters.named(Name.COPPER),
				Prompt.get(this)))) {
			player.addCoins(3, activation);
		}
	}

}
