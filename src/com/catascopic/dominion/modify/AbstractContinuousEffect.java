package com.catascopic.dominion.modify;

public abstract class AbstractContinuousEffect
		implements ContinuousEffect, ValueVisitor {

	@Override
	public final void modify(Value<?> value) {
		value.handle(this);
	}

	@Override
	public void modifyCost(CostValue value) {
		// do nothing by default
	}

	@Override
	public void modifyTypes(TypesValue value) {
		// do nothing by default
	}

	@Override
	public void modifyName(NameValue value) {
		// do nothing by default
	}

	@Override
	public void modifyAbilities(AbilitiesValue value) {
		// do nothing by default
	}

	@Override
	public void modifyAttackablePlayers(AttackablePlayersValue value) {
		// do nothing by default
	}

}
