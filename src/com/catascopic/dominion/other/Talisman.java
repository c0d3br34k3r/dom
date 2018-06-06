package com.catascopic.dominion.other;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Type;
import com.catascopic.dominion.event.Event;
import com.catascopic.dominion.event.EventVisitor;
import com.catascopic.dominion.event.GainEvent;
import com.catascopic.dominion.event.TrashEvent;
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
	public void trigger(final Activation activation, Event event) {
		event.handle(new EventVisitor() {

			@Override
			public void handleTrash(TrashEvent event) {

			}

			@Override
			public void handleGain(final GainEvent event) {
				if (event.player() == activation.player()
						&& event.card().cost() <= 4
						&& !event.card().types().contains(Type.VICTORY)) {
					event.addTrigger(new Trigger() {

						@Override
						public void resolve() {
							activation.player().gain(this, event.card().name());							
						}
					});
				}
			}
		});

	}

}
