package com.catascopic.dominion.base;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Type;
import com.catascopic.dominion.zone.SingleSelection;

class Vassal extends Identity {

	Vassal() {
		super(Name.VASSAL, 3, Type.ACTION);
	}

	@Override
	public void play(final Player player, Activation activation) {
		player.addCoins(2, activation);
		SingleSelection selection = player.deck().selectTop();
		player.discard(selection);
		if (!selection.isEmpty()
				&& selection.get().types().contains(Type.ACTION)) {
			player.play(selection);
		}
	}

}
