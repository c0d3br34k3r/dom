package com.catascopic.dominion.intrigue;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Game;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.TemporaryContinuousEffect;
import com.catascopic.dominion.Turn;
import com.catascopic.dominion.Type;
import com.catascopic.dominion.modify.CostValue;

class Bridge extends Identity {

	Bridge() {
		super(Name.BRIDGE, 4, Type.ACTION);
	}

	@Override
	public void play(Player player, Activation activation) {
		player.addBuy(activation);
		player.addCoin(activation);
		player.game().addContinuousEffect(new BridgeEffect(player.game()));
	}

	private static class BridgeEffect extends TemporaryContinuousEffect {

		private final Turn turn;

		BridgeEffect(Game game) {
			super(game);
			this.turn = game.currentTurn();
		}

		@Override
		public void modifyCost(CostValue cost) {
			cost.reduce(1);
		}

		@Override
		public boolean isRemoved() {
			return turn.isOver();
		}
	}

}
