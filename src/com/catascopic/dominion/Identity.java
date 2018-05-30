package com.catascopic.dominion;

import java.util.EnumSet;
import java.util.Set;

import com.catascopic.dominion.event.Context;
import com.catascopic.dominion.event.Event;
import com.catascopic.dominion.event.Triggers;
import com.catascopic.dominion.modify.ContinuousEffects;
import com.google.common.base.CaseFormat;
import com.google.common.collect.Sets;

public abstract class Identity implements Abilities {

	private final Name name;
	private final int cost;
	private final Set<Type> types;

	protected Identity(Name name, int cost, Type first, Type... rest) {
		this(name, cost, EnumSet.of(first, rest));
	}

	protected Identity(Name name, int cost, Set<Type> types) {
		this.name = name;
		this.cost = cost;
		this.types = Sets.immutableEnumSet(types);
		checkInvariants();
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

	public int value(Deck deck) {
		// warning if this isn't a victory or curse card
		return 0;
	}

	@Override
	public void play(Player player, Activation activation) {
		// warning if this isn't an action or treasure card
	}

	@Override
	public void trigger(Context context, Event event, Triggers triggers) {
		// do nothing by default
	}

	@Override
	public void continuousEffect(Context context, ContinuousEffects effects) {
		// do nothing by default
	}

	@Override
	public String toString() {
		return name.toString();
	}

	private static Set<Name> instances = EnumSet.noneOf(Name.class);

	private void checkInvariants() {
		if (!CaseFormat.UPPER_CAMEL
				.to(CaseFormat.UPPER_UNDERSCORE, getClass().getSimpleName())
				.equals(name.name())) {
			throw new IllegalStateException(
					getClass().getName() + " is named " + name);
		}
		synchronized (Identity.class) {
			if (!instances.add(name)) {
				throw new IllegalStateException("duplicate of " + name);
			}
		}
	}

}
