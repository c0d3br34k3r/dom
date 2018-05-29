package com.catascopic.dominion;

import java.util.EnumSet;
import java.util.Set;

import com.catascopic.dominion.zone.Selection;
import com.catascopic.dominion.zone.Zone;
import com.google.common.base.Predicate;

public class Player {

	private static final int SELECT_MAX = 99;

	private final Game game;

	private int actions;
	private int coins;
	private int buys;

	public Player(Game game) {
		this.game = game;
	}

	public Game game() {
		return game;
	}

	public Zone hand() {
		// TODO Auto-generated method stub
		return null;
	}

	// Vanilla bonuses

	public void addCoin(Activation activation) {
		addCoins(1, activation);
	}

	public void addCoins(int amount, Activation activation) {
		coins += amount;
	}

	public void addAction(Activation activation) {
		addActions(1, activation);
	}

	public void addActions(int amount, Activation activation) {
		actions += amount;
	}

	public void draw(Activation activation) {
		draw(1, activation);
	}

	public void draw(int amount, Activation activation) {
		// TODO
	}

	public void addBuy(Activation activation) {
		addBuys(1, activation);
	}

	private void addBuys(int amount, Activation activation) {
		buys += amount;
	}

	// Card selection

	public Selection selectOne(Zone zone,
			Predicate<Card> filter,
			Prompt prompt) {
		return select(zone, 1, 1, filter, prompt);
	}

	public Selection selectAnyNumber(Zone zone,
			Predicate<Card> filter,
			Prompt prompt) {
		return selectUpTo(zone, SELECT_MAX, filter, prompt);
	}

	public Selection selectUpTo(Zone zone,
			int max,
			Predicate<Card> filter,
			Prompt prompt) {
		return select(zone, 0, max, filter, prompt);
	}

	public Selection select(Zone zone,
			int min,
			int max,
			Predicate<Card> filter,
			Prompt prompt) {
		return null;
	}

	// Choices

	public Choice chooseOne(Prompt prompt) {
		return Choice.FIRST;
	}

	public Set<Choice> chooseTwo(Prompt prompt) {
		return EnumSet.of(Choice.FIRST, Choice.SECOND);
	}

	public void trash(Selection selection) {
		// TODO Auto-generated method stub

	}

}
