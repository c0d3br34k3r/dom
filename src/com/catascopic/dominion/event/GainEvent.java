package com.catascopic.dominion.event;

public class GainEvent extends MoveEvent {

	@Override
	public void handle(EventVisitor visitor, Context context) {
		visitor.handleGain(this, context);
	}

}
