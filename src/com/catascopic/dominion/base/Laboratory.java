package com.catascopic.dominion.base;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Type;

class Laboratory extends Identity {

	Laboratory() {
		super(Name.LABORATORY, 5, Type.ACTION);
	}

	@Override
	public void play(Player player, Activation activation) {
		player.draw(2, activation);
		player.addAction(activation);
	}

}
