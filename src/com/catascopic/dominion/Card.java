package com.catascopic.dominion;

import java.util.Set;

import com.catascopic.dominion.modify.AbilitiesValue;
import com.catascopic.dominion.modify.CostValue;
import com.catascopic.dominion.modify.NameValue;
import com.catascopic.dominion.modify.TypesValue;
import com.catascopic.dominion.zone.Location;

public class Card {

	private Identity identity;
	private int timestamp;
	private Location location;

	public Name name() {
		return game().calculate(new NameValue(this, identity.name()));
	}

	public int cost() {
		return game().calculate(new CostValue(this, identity.cost()));
	}

	public Set<Type> types() {
		return game().calculate(new TypesValue(this, identity.types()));
	}

	public int value(Deck deck) {
		return identity.value(deck);
	}

	public void play(Player player, Activation activation) {
		calculateAbilities().play(player, activation);
	}

	private Abilities calculateAbilities() {
		return game().calculate(new AbilitiesValue(this, identity));
	}

	private Game game() {
		// TODO Auto-generated method stub
		return null;
	}

	public Location location() {
		// TODO Auto-generated method stub
		return null;
	}

}
