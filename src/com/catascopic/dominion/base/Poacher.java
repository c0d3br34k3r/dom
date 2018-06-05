package com.catascopic.dominion.base;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Filters;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Prompt;
import com.catascopic.dominion.Type;

class Poacher extends Identity {

	Poacher() {
		super(Name.POACHER, 4, Type.ACTION);
	}

	@Override
	public void play(Player player, Activation activation) {
		player.draw(activation);
		player.addAction(activation);
		player.addCoin(activation);
		player.discard(activation, player.selectExactly(
				player.hand(),
				player.game().supply().emptyPiles(),
				Filters.ANY,
				Prompt.get(this)));
	}

}
