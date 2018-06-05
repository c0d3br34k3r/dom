package com.catascopic.dominion.base;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Type;

class Smithy extends Identity {

	Smithy() {
		super(Name.SMITHY, 4, Type.ACTION);
	}

	@Override
	public void play(Player player, Activation activation) {
		player.draw(3, activation);
	}

}
