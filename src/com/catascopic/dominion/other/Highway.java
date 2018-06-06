package com.catascopic.dominion.other;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Type;
import com.catascopic.dominion.modify.AbstractContinuousEffect;
import com.catascopic.dominion.modify.ContinuousEffect;
import com.catascopic.dominion.modify.ContinuousEffects;
import com.catascopic.dominion.modify.CostValue;

class Highway extends Identity {

	Highway() {
		super(Name.HIGHWAY, 5, Type.ACTION);
	}

	@Override
	public void play(Player player, Activation activation) {
		player.draw(activation);
		player.addAction(activation);
	}

	@Override
	public void getContinuousEffectsLayer2(ContinuousEffects effects) {
		effects.add(REDUCE_COST);
	}

	private static final ContinuousEffect REDUCE_COST =
			new AbstractContinuousEffect() {

				@Override
				public void modifyCost(CostValue cost) {
					cost.reduce(1);
				}

				@Override
				public String toString() {
					return "all cards cost 1 less";
				}
			};

}
