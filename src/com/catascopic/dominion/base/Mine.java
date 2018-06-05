package com.catascopic.dominion.base;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Filters;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Prompt;
import com.catascopic.dominion.Type;
import com.catascopic.dominion.zone.SingleSelection;
import com.google.common.base.Predicates;

class Mine extends Identity {

	Mine() {
		super(Name.MINE, 5, Type.ACTION);
	}

	@Override
	public void play(Player player, Activation activation) {
		SingleSelection selection = player.selectOne(
				player.hand(),
				Filters.TREASURE,
				Prompt.get(0, this));
		if (player.trash(activation, selection)) {
			player.gain(activation, player.selectOne(
					player.game().supply(),
					Predicates.and(Filters.TREASURE,
							Filters.costingUpTo(selection.get().cost() + 3)),
					Prompt.get(1, this)));
		}
	}

}
