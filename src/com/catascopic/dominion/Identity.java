package com.catascopic.dominion;

import java.util.EnumSet;
import java.util.Set;

import com.catascopic.dominion.event.Context;
import com.catascopic.dominion.event.Event;
import com.catascopic.dominion.event.EventVisitor;
import com.catascopic.dominion.event.GainEvent;
import com.catascopic.dominion.event.PlayEvent;
import com.catascopic.dominion.event.TrashEvent;
import com.catascopic.dominion.modify.AbilitiesValue;
import com.catascopic.dominion.modify.AttackablePlayersValue;
import com.catascopic.dominion.modify.ContinuousEffects;
import com.catascopic.dominion.modify.CostValue;
import com.catascopic.dominion.modify.NameValue;
import com.catascopic.dominion.modify.TypesValue;
import com.catascopic.dominion.modify.ValueVisitor;
import com.google.common.base.CaseFormat;
import com.google.common.collect.Sets;

public abstract class Identity implements Abilities, EventVisitor,
		ValueVisitor {

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

	public int value(CombinedDeck deck) {
		// warning if this isn't a victory or curse card
		return 0;
	}

	@Override
	public void play(Player player, Activation activation) {
		// warning if this isn't an action or treasure card
	}

	@Override
	public void trigger(Event event, Context context) {
		event.handle(this, context);
	}

	@Override
	public void getContinuousEffects(ContinuousEffects effects) {
		// TODO: cards' continuous effects cannot modify abilities!
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		return name.toString();
	}

	// Default listener methods

	@Override
	public void handleTrash(TrashEvent event, Context context) {}

	@Override
	public void handleGain(GainEvent event, Context context) {}

	@Override
	public void handlePlay(PlayEvent event, Context context) {}

	@Override
	public void modifyCost(CostValue cost) {}

	@Override
	public void modifyName(NameValue name) {}

	@Override
	public void modifyTypes(TypesValue types) {}

	@Override
	public void modifyAbilities(AbilitiesValue abilities) {}

	@Override
	public void modifyAttackablePlayers(AttackablePlayersValue value) {}
	
	//

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
