package com.catascopic.dominion.modify;

import java.util.Set;

import com.catascopic.dominion.Player;
import com.google.common.collect.Sets;

public class AttackablePlayersValue implements Value<Set<Player>> {

	private Set<Player> players;

	public AttackablePlayersValue(Player player) {
		this.players = Sets.newHashSet(player.opponents());
	}

	@Override
	public void handle(ValueVisitor visitor) {
		visitor.modifyAttackablePlayers(this);
	}

	public void protect(Player player) {
		players.remove(player);
	}

	@Override
	public Set<Player> get() {
		return players;
	}

}
