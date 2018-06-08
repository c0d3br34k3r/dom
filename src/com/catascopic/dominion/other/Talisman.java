package com.catascopic.dominion.other;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Card;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Type;
import com.catascopic.dominion.event.Context;
import com.catascopic.dominion.event.GainEvent;
import com.catascopic.dominion.event.Trigger;

class Talisman extends Identity {

	Talisman() {
		super(Name.TALISMAN, 4, Type.TREASURE);
	}

	@Override
	public void play(Player player, Activation activation) {
		player.addCoin(activation);
	}

	@Override
	public void handleGain(GainEvent event, Context context) {
		if (context.inPlay()
				&& event.player() == context.owner()
				&& event.card().cost() <= 4
				&& !event.card().types().contains(Type.VICTORY)) {
			event.addTrigger(new TalismanTrigger(
					context.owner(), event.card()));
		}
	}

	private static class TalismanTrigger implements Trigger {

		private final Player player;
		private final Card card;

		TalismanTrigger(Player player, Card card) {
			this.player = player;
			this.card = card;
		}

		@Override
		public void resolve() {
			player.gain(this, card.name());
		}

		@Override
		public String toString() {
			return player + " gains a copy of " + card;
		}
	}

}
