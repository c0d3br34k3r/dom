package com.catascopic.dominion.base;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Prompt;
import com.catascopic.dominion.Type;
import com.catascopic.dominion.zone.SingleSelection;
import com.catascopic.dominion.zone.TemporaryZone;

class Library extends Identity {

	Library() {
		super(Name.LIBRARY, 5, Type.ACTION);
	}

	@Override
	public void play(Player player, Activation activation) {
		try (TemporaryZone setAside = new TemporaryZone()) {
			while (player.hand().size() < 7) {
				SingleSelection selection = player.drawAndSelect(activation);
				if (selection.isEmpty()) {
					break;
				}
				if (selection.get().types().contains(Type.ACTION)
						&& player.yesNo(Prompt.get(this))) {
					// TODO: how far do I go with Source?
					setAside.accept(selection);
				}
			}
			player.discard(activation, setAside.selectAll());
		}
	}

}
