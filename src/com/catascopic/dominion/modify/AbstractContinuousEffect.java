package com.catascopic.dominion.modify;

public abstract class AbstractContinuousEffect
		implements ContinuousEffect, ValueVisitor {

	@Override
	public final void modify(Value<?> value) {
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
