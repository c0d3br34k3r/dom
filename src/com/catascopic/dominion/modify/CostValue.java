package com.catascopic.dominion.modify;

import com.catascopic.dominion.Card;

public class CostValue extends CardValue<Integer> {

	private int cost;

	public CostValue(Card card, int cost) {
		super(card);
		this.cost = cost;
	}

	@Override
	public void handle(ValueVisitor visitor) {
		visitor.modifyCost(this);
	}

	public void reduce(int amount) {
		cost = Integer.max(cost - amount, 0);
	}

	@Override
	public Integer get() {
		return cost;
	}

}
