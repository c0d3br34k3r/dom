package com.catascopic.dominion.base;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Filters;
import com.catascopic.dominion.Identity;
import com.catascopic.dominion.Name;
import com.catascopic.dominion.PileName;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Prompt;
import com.catascopic.dominion.Type;

class Bureaucrat extends Identity {

	Bureaucrat() {
		super(Name.BUREAUCRAT, 4, Type.ACTION, Type.ATTACK);
	}

	@Override
	public void play(Player player, Activation activation) {
		player.gainToDeck(activation, PileName.SILVER);
		// TODO: multithreading?
		for (Player opponent : player.getAttacks(activation)) {
			opponent.moveOntoDeck(activation, opponent.selectOne(
					opponent.hand(),
					Filters.VICTORY,
					Prompt.get(this)));
		}
	}

}
