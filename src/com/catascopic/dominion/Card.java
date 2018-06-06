package com.catascopic.dominion;

import java.util.Set;

import com.catascopic.dominion.modify.AbilitiesValue;
import com.catascopic.dominion.modify.ContinuousEffect;
import com.catascopic.dominion.modify.CostValue;
import com.catascopic.dominion.modify.NameValue;
import com.catascopic.dominion.modify.TypesValue;
import com.catascopic.dominion.modify.Value;
import com.catascopic.dominion.zone.Location;

public class Card implements ContinuousEffect {

	private Identity identity;
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

	public int value(CombinedDeck deck) {
		return identity.value(deck);
	}

	public void play(Player player, Activation activation) {
		calculateAbilities().play(player, activation);
	}

	@Override
	public void modify(Value<?> value) {
		calculateAbilities().modify(value);
	}

	private Abilities calculateAbilities() {
		return game().calculate(new AbilitiesValue(this, identity));
	}

	private Game game() {
		// TODO Auto-generated method stub
		return null;
	}

	public Location location() {
		return location;
	}

	public PileName pile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int timestamp() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Identity identity() {
		// TODO Auto-generated method stub
		return null;
	}

}
