package com.catascopic.dominion.base;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Type;
import com.catascopic.dominion.event.Context;
import com.catascopic.dominion.event.DelayedTrigger;
import com.catascopic.dominion.event.Event;

class Merchant extends Identity {

	Merchant() {
		super(Name.MERCHANT, 3, Type.ACTION);
	}

	@Override
	public void play(final Player player, Activation activation) {
		player.draw(activation);
		player.addAction(activation);
		player.game().addDelayedTrigger(new DelayedTrigger() {

			@Override
			public boolean triggers(Context context, Event event) {
				// TODO
				return false;
			}

			@Override
			public void effect() {
				player.addCoin(this);
			}
		});
	}

}
