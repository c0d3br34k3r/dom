package com.catascopic.dominion.base;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Filters;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Prompt;
import com.catascopic.dominion.Type;

class ThroneRoom extends Identity {

	ThroneRoom() {
		super(Name.THRONE_ROOM, 4, Type.ACTION);
	}

	@Override
	public void play(Player player, Activation activation) {
		activation.play(player.maySelectOne(
				player.hand(),
				Filters.ACTION,
				Prompt.get(this)), 2);
	}

}
