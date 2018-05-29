package com.catascopic.dominion;

public class Player {

	private final Game game;
	private int actions;
	private int coins;
	private int buys;

	public Player(Game game) {
		this.game = game;
	}

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

	public Game game() {
		return game;
	}

}
