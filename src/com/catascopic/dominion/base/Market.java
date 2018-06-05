package com.catascopic.dominion.base;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Type;

class Market extends Identity {

	Market() {
		super(Name.MARKET, 5, Type.ACTION);
	}

	@Override
	public void play(Player player, Activation activation) {
		player.draw(activation);
		player.addAction(activation);
		player.addBuy(activation);
		player.addCoin(activation);
	}

}
