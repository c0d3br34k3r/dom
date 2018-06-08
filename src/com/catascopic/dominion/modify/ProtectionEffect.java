package com.catascopic.dominion.modify;

import com.catascopic.dominion.Activation;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.Source;

public class ProtectionEffect extends TemporaryContinuousEffect {

	private final Source source;
	private final Player player;
	private final Activation activation;

	public ProtectionEffect(Source source, Player player,
			Activation activation) {
		super(player.game());
		this.source = source;
		this.player = player;
		this.activation = activation;
	}

	@Override
	public void modifyAttackablePlayers(AttackablePlayersValue value) {
		value.protect(player);
	}

	@Override
	public boolean isRemoved() {
		return activation.isFinished();
	}

	@Override
	public String toString() {
		return String.format("[%s] %s is protected from %s",
				source, player, activation);
	}

}
