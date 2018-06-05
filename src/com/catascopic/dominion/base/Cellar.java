package com.catascopic.dominion.base;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Filters;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Prompt;
import com.catascopic.dominion.Type;
import com.catascopic.dominion.zone.Selection;

class Cellar extends Identity {

	Cellar() {
		super(Name.CELLAR, 2, Type.ACTION);
	}

	@Override
	public void play(Player player, Activation activation) {
		player.addAction(activation);
		Selection selection = player.selectAnyNumber(
				player.hand(),
				Filters.ANY,
				Prompt.get(this));
		player.discard(activation, selection);
		player.draw(selection.cards().size(), activation);
	}

}
