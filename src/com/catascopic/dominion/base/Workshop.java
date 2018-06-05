package com.catascopic.dominion.base;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Filters;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Prompt;
import com.catascopic.dominion.Type;

class Workshop extends Identity {

	Workshop() {
		super(Name.WORKSHOP, 3, Type.ACTION);
	}

	@Override
	public void play(Player player, Activation activation) {
		player.gain(activation, player.selectOne(
				player.game().supply(),
				Filters.costingUpTo(4),
				Prompt.get(this)));
	}

}
