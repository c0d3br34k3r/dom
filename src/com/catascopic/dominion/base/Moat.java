package com.catascopic.dominion.base;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Prompt;
import com.catascopic.dominion.Type;
import com.catascopic.dominion.event.Context;
import com.catascopic.dominion.event.PlayEvent;
import com.catascopic.dominion.event.Trigger;
import com.catascopic.dominion.modify.ProtectionEffect;

class Moat extends Identity {

	Moat() {
		super(Name.MOAT, 2, Type.ACTION, Type.REACTION);
	}

	@Override
	public void play(Player player, Activation activation) {
		player.draw(2, activation);
	}

	@Override
	public void handlePlay(PlayEvent event, Context context) {
		if (context.inHand()
				&& event.player() != context.owner()
				&& event.card().types().contains(Type.ATTACK)) {
			event.addTrigger(new MoatTrigger(
					context.owner(), event.activation()));
		}
	}

	private static class MoatTrigger implements Trigger {

		private final Player player;
		private final Activation activation;

		MoatTrigger(Player player, Activation activation) {
			this.player = player;
			this.activation = activation;
		}

		@Override
		public void resolve() {
			if (player.yesNo(Prompt.get(this))) {
				player.game().addContinuousEffect(
						new ProtectionEffect(this, player, activation));
			}
		}

		@Override
		public String toString() {
			return "protect " + player + " from " + activation;
		}
	}

}
