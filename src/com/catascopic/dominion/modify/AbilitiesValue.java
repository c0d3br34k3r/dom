package com.catascopic.dominion.modify;

import com.catascopic.dominion.Abilities;
import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Card;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.event.Context;
import com.catascopic.dominion.event.Event;
import com.catascopic.dominion.event.Triggers;

public class AbilitiesValue extends CardValue<Abilities> {

	private Abilities abilities;

	public AbilitiesValue(Card card, Abilities abilities) {
		super(card);
		this.abilities = abilities;
	}

	@Override
	public void handle(ValueVisitor visitor) {
		visitor.modifyAbilities(this);
	}

	public void replace(Abilities newAbilities) {
		abilities = newAbilities;
	}

	public void combine(final Abilities newAbilities) {
		abilities = new Abilities() {

			@Override
			public void play(Player player, Activation activation) {
				abilities.play(player, activation);
				newAbilities.play(player, activation);
			}

			@Override
			public void trigger(Context context, Event event,
					Triggers triggers) {
				abilities.trigger(context, event, triggers);
				newAbilities.trigger(context, event, triggers);
			}

			@Override
			public void continuousEffect(Context context,
					ContinuousEffects effects) {
				abilities.continuousEffect(context, effects);
				newAbilities.continuousEffect(context, effects);
			}
		};
	}

	@Override
	public Abilities get() {
		return abilities;
	}

}
