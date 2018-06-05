package com.catascopic.dominion;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

public class Filters {

	public static final Predicate<Card> ANY = Predicates.alwaysTrue();

	public static final Predicate<Card> ACTION = filterType(Type.ACTION);
	public static final Predicate<Card> TREASURE = filterType(Type.TREASURE);
	public static final Predicate<Card> VICTORY = filterType(Type.VICTORY);

	private static Predicate<Card> filterType(final Type type) {
		return new Predicate<Card>() {

			@Override
			public boolean apply(Card card) {
				return card.types().contains(type);
			}
		};
	}

	public static Predicate<Card> costingUpTo(final int cost) {
		return new Predicate<Card>() {

			@Override
			public boolean apply(Card card) {
				return card.cost() <= cost;
			}
		};
	}

	public static Predicate<Card> named(final Name name) {
		return new Predicate<Card>() {

			@Override
			public boolean apply(Card card) {
				return card.name() == name;
			}
		};
	}

}
