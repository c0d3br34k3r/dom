package com.catascopic.dominion.other;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Type;
import com.catascopic.dominion.modify.CostValue;

class Highway extends Identity {

	Highway() {
		super(Name.ARTISAN, 5, Type.ACTION);
	}

	@Override
	public void play(Player player, Activation activation) {
		player.draw(activation);
		player.addAction(activation);
	}

	@Override
	public void modifyCost(CostValue cost) {
		cost.reduce(1);
	}

}
