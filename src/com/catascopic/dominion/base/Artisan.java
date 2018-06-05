package com.catascopic.dominion.base;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Filters;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Prompt;
import com.catascopic.dominion.Type;

class Artisan extends Identity {

	Artisan() {
		super(Name.ARTISAN, 6, Type.ACTION);
	}

	@Override
	public void play(Player player, Activation activation) {
		player.gainToHand(activation, player.selectOne(
				player.game().supply(),
				Filters.costingUpTo(5),
				Prompt.get(0, this)));
		player.moveOntoDeck(activation, player.selectOne(
				player.hand(),
				Filters.ANY,
				Prompt.get(1, this)));
	}

}
