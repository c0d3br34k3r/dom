package com.catascopic.dominion.modify;

import com.catascopic.dominion.Abilities;
import com.catascopic.dominion.Card;

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

	@Override
	public Abilities get() {
		return abilities;
	}

}
