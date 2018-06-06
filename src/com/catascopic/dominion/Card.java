package com.catascopic.dominion;

import java.util.Set;

import com.catascopic.dominion.modify.AbilitiesValue;
import com.catascopic.dominion.modify.ContinuousEffectSource;
import com.catascopic.dominion.modify.ContinuousEffects;
import com.catascopic.dominion.modify.CostValue;
import com.catascopic.dominion.modify.NameValue;
import com.catascopic.dominion.modify.TypesValue;
import com.catascopic.dominion.zone.Location;

public class Card implements ContinuousEffectSource {

	private Identity identity;
	private Location location;
	private Game game;

	public Card(Game game, Identity identity) {
		this.game = game;
		this.identity = identity;
	}

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

	private Abilities calculateAbilities() {
		return game().calculate(new AbilitiesValue(this, identity));
	}

	private Game game() {
		return game;
	}

	public Location location() {
		return location;
	}

	public PileName pile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getContinuousEffectsLayer1(ContinuousEffects effects) {
		calculateAbilities().getContinuousEffectsLayer1(effects);
	}
	
	@Override
	public void getContinuousEffectsLayer2(ContinuousEffects effects) {
		calculateAbilities().getContinuousEffectsLayer2(effects);
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

	@Override
	public String toString() {
		return identity.toString();
	}

}
