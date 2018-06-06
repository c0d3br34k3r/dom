package com.catascopic.dominion.event;

import com.catascopic.dominion.Player;

public abstract class Event {

	public abstract void handle(EventVisitor visitor);

	public void resolveTriggers() {
		// TODO Auto-generated method stub

	}

	public void addTrigger(Trigger trigger) {
		// TODO Auto-generated method stub

	}

	public Player player() {
		// TODO Auto-generated method stub
		return null;
	}

}
