package com.catascopic.dominion.event;

import com.catascopic.dominion.Card;
import com.catascopic.dominion.Player;

public class TrashEvent extends MoveEvent {

	public TrashEvent(Player player, Card card) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(EventVisitor visitor) {
		visitor.handleTrash(this);
	}

}
