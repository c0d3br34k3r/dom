package com.catascopic.dominion.base;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Type;

class CouncilRoom extends Identity {

	CouncilRoom() {
		super(Name.COUNCIL_ROOM, 5, Type.ACTION);
	}

	@Override
	public void play(Player player, Activation activation) {
		player.draw(4, activation);
		player.addBuy(activation);
		for (Player opponent : player.opponents()) {
			opponent.draw(activation);
		}
	}

}
