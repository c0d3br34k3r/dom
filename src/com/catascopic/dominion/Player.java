package com.catascopic.dominion;

import java.util.EnumSet;
import java.util.Set;

import com.catascopic.dominion.zone.Deck;
import com.catascopic.dominion.zone.Selection;
import com.catascopic.dominion.zone.SingleSelection;
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

	public Deck deck() {
		// TODO Auto-generated method stub
		return null;
	}

	public Zone discardPile() {
		// TODO Auto-generated method stub
		return null;
	}

	// Vanilla bonuses

	public void addCoin(Source source) {
		addCoins(1, source);
	}

	public void addCoins(int amount, Source source) {
		coins += amount;
	}

	public void addAction(Source source) {
		addActions(1, source);
	}

	public void addActions(int amount, Source source) {
		actions += amount;
	}

	public void draw(Source source) {
		draw(1, source);
	}

	public void draw(int amount, Source source) {
		// TODO
	}

	public void addBuy(Source source) {
		addBuys(1, source);
	}

	private void addBuys(int amount, Source source) {
		buys += amount;
	}

	// Card selection

	public Selection selectOne(Zone zone,
			Predicate<Card> filter,
			Prompt prompt) {
		return select(zone, 1, 1, filter, prompt);
	}

	public Selection maySelectOne(Zone zone,
			Predicate<Card> filter,
			Prompt prompt) {
		return selectUpTo(zone, 1, filter, prompt);
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

	public void discard(Selection selection) {
		// TODO Auto-generated method stub
	}

	public void moveOntoDeck(Selection selection) {
		// TODO Auto-generated method stub
	}

	public void play(SingleSelection selection) {
		// TODO Auto-generated method stub
	}

}
