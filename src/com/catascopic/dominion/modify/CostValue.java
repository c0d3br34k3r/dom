package com.catascopic.dominion.modify;

import com.catascopic.dominion.Card;

public class CostValue extends CardValue<Integer> {

	private int cost;
	private int modifier;

	public CostValue(Card card, int cost) {
		super(card);
		this.cost = cost;
	}

	@Override
	public void handle(ValueVisitor visitor) {
		visitor.modifyCost(this);
	}

	public void reduce(int amount) {
		modifier -= amount;
	}

	public void set(int baseCost) {
		cost = baseCost;
	}

	@Override
	public Integer get() {
		return Math.max(cost + modifier, 0);
	}

}
