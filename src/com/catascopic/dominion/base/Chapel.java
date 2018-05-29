package com.catascopic.dominion.base;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Filters;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Prompt;
import com.catascopic.dominion.Type;

class Chapel extends Identity {

	Chapel() {
		super(Name.CHAPEL, 2, Type.ACTION);
	}

	@Override
	public void play(Player player, Activation activation) {
		player.trash(player.selectAnyNumber(
				player.hand(),
				Filters.ANY,
				Prompt.get(Name.CHAPEL)));
	}

}
