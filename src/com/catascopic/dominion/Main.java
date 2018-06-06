package com.catascopic.dominion;

import com.catascopic.dominion.base.Base;
import com.catascopic.dominion.basic.Basic;
import com.catascopic.dominion.modify.AbilitiesValue;
import com.catascopic.dominion.modify.CostValue;
import com.catascopic.dominion.modify.NameValue;
import com.catascopic.dominion.modify.TemporaryContinuousEffect;
import com.catascopic.dominion.modify.TypesValue;
import com.catascopic.dominion.other.Test;

public class Main {

	public static void main(String[] args) {
		Game game = new Game();

		game.tick();
		Card highway = new Card(game, Test.HIGHWAY);
		Card estate = new Card(game, Basic.ESTATE);
		// game.addContinuousEffect(new CopyEffect(game, Base.VILLAGE, estate));
		// game.tick();
		game.addContinuousEffect(new CopyEffect(game, Test.HIGHWAY, estate));
		Player player = new Player(game, estate);
		game.addPlayer(player);
		System.out.println(estate.cost());
	}

	private static class CopyEffect extends TemporaryContinuousEffect {

		private final Identity copy;
		private final Card card;

		public CopyEffect(Game game, Identity copy, Card card) {
			super(1, game);
			this.copy = copy;
			this.card = card;
		}

		@Override
		public void modifyCost(CostValue cost) {
			if (cost.card().equals(card)) {
				cost.set(copy.cost());
			}
		}

		@Override
		public void modifyTypes(TypesValue types) {
			if (types.card().equals(card)) {
				types.set(copy.types());
			}
		}

		@Override
		public void modifyName(NameValue name) {
			if (name.card().equals(card)) {
				name.set(copy.name());
			}
		}

		@Override
		public void modifyAbilities(AbilitiesValue abilities) {
			if (abilities.card().equals(card)) {
				abilities.set(copy);
			}
		}

		@Override
		public boolean isRemoved() {
			return false;
		}

		@Override
		public String toString() {
			return card + " is a copy of " + copy;
		}
	}

}
