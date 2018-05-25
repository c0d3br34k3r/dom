package com.catascopic.dominion;

import java.util.EnumSet;
import java.util.Set;

public abstract class Identity implements Action, Victory {

	private final Name name;
	private final int cost;
	private final Set<Type> types;

	protected Identity(Name name, int cost, Type first, Type... rest) {
		this(name, cost, EnumSet.of(first, rest));
	}

	protected Identity(Name name, int cost, Set<Type> types) {
		this.name = name;
		this.cost = cost;
		this.types = types;
	}

	public final Name name() {
		return name;
	}

	public final int cost() {
		return cost;
	}

	public final Set<Type> types() {
		return types;
	}

	@Override
	public int value(Deck deck) {
		// warning if this isn't a victory or curse card
		return 0;
	}

	@Override
	public void play(Player player, Activation activation) {
		// warning if this isn't an action or treasure card
	}

	@Override
	public String toString() {
		return name.toString();
	}

}
