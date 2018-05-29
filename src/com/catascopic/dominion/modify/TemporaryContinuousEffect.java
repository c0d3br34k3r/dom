package com.catascopic.dominion.modify;

import com.catascopic.dominion.AutoRemovable;
import com.catascopic.dominion.Game;
import com.google.common.collect.ComparisonChain;

public abstract class TemporaryContinuousEffect
		implements ContinuousEffect, ValueVisitor, AutoRemovable {

	private final int timestamp;
	private final Layer layer;

	public TemporaryContinuousEffect(Game game, Layer layer) {
		this.timestamp = game.getTime();
		this.layer = layer;
	}

	@Override
	public int timestamp() {
		return timestamp;
	}

	@Override
	public Layer layer() {
		return layer;
	}

	@Override
	public void modify(Value<?> value) {
		value.handle(this);
	}

	@Override
	public int compareTo(ContinuousEffect o) {
		return ComparisonChain.start()
				.compare(layer, o.layer())
				.compare(timestamp, o.timestamp())
				.result();
	}

	@Override
	public void modifyCost(CostValue cost) {
		// do nothing by default
	}

	@Override
	public void modifyTypes(TypesValue types) {
		// do nothing by default
	}

	@Override
	public void modifyName(NameValue name) {
		// do nothing by default
	}

	@Override
	public void modifyAbilities(AbilitiesValue abilitiesValue) {
		// do nothing by default
	}

}
