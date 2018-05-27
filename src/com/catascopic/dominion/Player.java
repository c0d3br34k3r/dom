package com.catascopic.dominion;

public class Player {

	private final Game game;

	private int actions;
	private int coins;

	public Player(Game game) {
		this.game = game;
	}

	public void addCoin(Activation activation) {
		addCoins(1, activation);
	}

	public void addCoins(int amount, Activation activation) {
		// TODO Auto-generated method stub
	}

	public void addAction(Activation activation) {
		addActions(1, activation);
	}

	public void addActions(int i, Activation activation) {
		// TODO Auto-generated method stub
	}

	public void draw(Activation activation) {
		draw(1, activation);
	}

	public void draw(int i, Activation activation) {
		// TODO Auto-generated method stub
	}

	public void addBuy(Activation activation) {
		addBuys(1, activation);
	}

	private void addBuys(int amount, Activation activation) {
		// TODO Auto-generated method stub
	}

	public Game game() {
		// TODO Auto-generated method stub
		return null;
	}

}
