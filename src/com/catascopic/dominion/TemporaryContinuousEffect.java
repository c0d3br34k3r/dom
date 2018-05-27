package com.catascopic.dominion;

import com.catascopic.dominion.modify.AbilitiesValue;
import com.catascopic.dominion.modify.CostValue;
import com.catascopic.dominion.modify.NameValue;
import com.catascopic.dominion.modify.TypesValue;
import com.catascopic.dominion.modify.Value;
import com.catascopic.dominion.modify.ValueVisitor;

public abstract class TemporaryContinuousEffect
		implements ContinuousEffect, ValueVisitor, AutoRemovable {

	private final int timestamp;

	public TemporaryContinuousEffect(Game game) {
		this.timestamp = game.getTimestamp();
	}

	@Override
	public int timestamp() {
		return timestamp;
	}

	@Override
	public Layer layer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void handle(Value<?> value) {
		value.handle(this);
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
