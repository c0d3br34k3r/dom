package com.catascopic.dominion.base;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Filters;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Prompt;
import com.catascopic.dominion.Type;
import com.catascopic.dominion.zone.SingleSelection;

class Remodel extends Identity {

	Remodel() {
		super(Name.REMODEL, 4, Type.ACTION);
	}

	@Override
	public void play(Player player, Activation activation) {
		SingleSelection selection = player.selectOne(
				player.hand(),
				Filters.ANY,
				Prompt.get(0, this));
		if (player.trash(activation, selection)) {
			player.gain(activation, player.selectOne(
					player.game().supply(),
					Filters.costingUpTo(selection.get().cost() + 2),
					Prompt.get(1, this)));
		}
	}

}
