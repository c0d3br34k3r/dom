package com.catascopic.dominion.modify;

import com.catascopic.dominion.AutoRemovable;
import com.catascopic.dominion.Game;

public abstract class TemporaryContinuousEffect extends AbstractContinuousEffect
		implements AutoRemovable {

	private final int timestamp;

	public TemporaryContinuousEffect(Game game) {
		this.timestamp = game.getTime();
	}

	@Override
	public int timestamp() {
		return timestamp;
	}

}
