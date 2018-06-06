package com.catascopic.dominion.base;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Filters;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Prompt;
import com.catascopic.dominion.Type;

class Cellar extends Identity {

	Cellar() {
		super(Name.CELLAR, 2, Type.ACTION);
	}

	@Override
	public void play(Player player, Activation activation) {
		player.addAction(activation);
		player.draw(player.discard(activation, player.selectAnyNumber(
				player.hand(),
				Filters.ANY,
				Prompt.get(this))).size(), activation);
	}

}
