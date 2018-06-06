package com.catascopic.dominion.modify;

import com.catascopic.dominion.AutoRemovable;
import com.catascopic.dominion.Game;

public abstract class TemporaryContinuousEffect extends AbstractContinuousEffect
		implements ContinuousEffectSource, AutoRemovable {

	private final int timestamp;
	private int layer;

	public TemporaryContinuousEffect(int layer, Game game) {
		this.timestamp = game.getTime();
		this.layer = layer;
	}

	@Override
	public void getContinuousEffectsLayer1(ContinuousEffects effects) {
		if (layer == 1) {
			effects.add(this);
		}
	}

	@Override
	public void getContinuousEffectsLayer2(ContinuousEffects effects) {
		if (layer == 1) {
			effects.add(this);
		}
	}

	@Override
	public final int timestamp() {
		return timestamp;
	}

}
