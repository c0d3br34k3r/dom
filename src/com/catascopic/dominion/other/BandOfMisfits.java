package com.catascopic.dominion.other;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Filters;
import com.catascopic.dominion.Game;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Prompt;
import com.catascopic.dominion.Type;
import com.catascopic.dominion.modify.AbilitiesValue;
import com.catascopic.dominion.modify.CostValue;
import com.catascopic.dominion.modify.NameValue;
import com.catascopic.dominion.modify.TemporaryContinuousEffect;
import com.catascopic.dominion.modify.TypesValue;
import com.catascopic.dominion.zone.SingleSelection;

class BandOfMisfits extends Identity {

	BandOfMisfits() {
		super(Name.ARTISAN, 5, Type.ACTION);
	}

	@Override
	public void play(Player player, final Activation activation) {
		SingleSelection selected = player.selectOne(
				player.game().supply(),
				Filters.ANY,
				Prompt.get(this));
		if (!selected.isEmpty()) {
			player.game().addContinuousEffect(new CopyEffect(player.game(),
					selected.get().identity(), activation));
			activation.playAs(activation.self(), selected.get());
		}
	}

	private static class CopyEffect extends TemporaryContinuousEffect {

		private final Identity copy;
		private final Activation activation;

		public CopyEffect(Game game, Identity copy, Activation activation) {
			super(game);
			this.copy = copy;
			this.activation = activation;
		}

		@Override
		public void modifyCost(CostValue cost) {
			cost.set(copy.cost());
		}

		@Override
		public void modifyTypes(TypesValue types) {
			types.set(copy.types());
		}

		@Override
		public void modifyName(NameValue name) {
			name.set(copy.name());
		}

		@Override
		public void modifyAbilities(AbilitiesValue abilities) {
			abilities.set(copy);
		}

		@Override
		public boolean isRemoved() {
			return activation.isInPlay();
		}
	}

}
