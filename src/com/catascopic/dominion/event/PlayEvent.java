package com.catascopic.dominion.event;

import com.catascopic.dominion.Activation;

public class PlayEvent extends MoveEvent {

	@Override
	public void handle(EventVisitor visitor, Context context) {
		visitor.handlePlay(this, context);
	}

	public Activation activation() {
		// TODO Auto-generated method stub
		return null;
	}

}
