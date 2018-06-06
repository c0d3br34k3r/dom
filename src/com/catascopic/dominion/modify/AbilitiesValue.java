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

	public void set(Abilities newAbilities) {
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
			public void getContinuousEffectsLayer1(ContinuousEffects effects) {
				abilities.getContinuousEffectsLayer1(effects);
				newAbilities.getContinuousEffectsLayer1(effects);
			}
			
			@Override
			public void getContinuousEffectsLayer2(ContinuousEffects effects) {
				abilities.getContinuousEffectsLayer2(effects);
				newAbilities.getContinuousEffectsLayer2(effects);
			}
		};
	}

	@Override
	public Abilities get() {
		return abilities;
	}

}
