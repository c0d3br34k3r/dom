package com.catascopic.dominion.base;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Filters;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Prompt;
import com.catascopic.dominion.Type;

class Harbinger extends Identity {

	Harbinger() {
		super(Name.HARBINGER, 3, Type.ACTION);
	}

	@Override
	public void play(Player player, Activation activation) {
		player.draw(activation);
		player.addAction(activation);
		player.moveOntoDeck(activation, player.maySelectOne(
				player.discardPile(),
				Filters.ANY,
				Prompt.get(this)));
	}

}
