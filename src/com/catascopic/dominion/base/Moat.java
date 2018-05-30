package com.catascopic.dominion.base;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Type;
import com.catascopic.dominion.event.Context;
import com.catascopic.dominion.event.Event;
import com.catascopic.dominion.event.Triggers;

class Moat extends Identity {

	Moat() {
		super(Name.MOAT, 2, Type.ACTION, Type.REACTION);
	}

	@Override
	public void play(Player player, Activation activation) {
		player.draw(2, activation);
	}

	@Override
	public void trigger(Context context, Event event, Triggers triggers) {
		// TODO
	}

}
