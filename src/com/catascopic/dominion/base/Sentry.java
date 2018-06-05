package com.catascopic.dominion.base;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Filters;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Prompt;
import com.catascopic.dominion.Type;
import com.catascopic.dominion.zone.TemporaryZone;

class Sentry extends Identity {

	Sentry() {
		super(Name.SENTRY, 5, Type.ACTION);
	}

	@Override
	public void play(Player player, Activation activation) {
		player.draw(activation);
		player.addAction(activation);
		// TODO:
		try (TemporaryZone lookingAt = player.deck().lookAtTop(2)) {
			player.selectAnyNumber(lookingAt, Filters.ANY, Prompt.get(1, this));
		}
	}

}
