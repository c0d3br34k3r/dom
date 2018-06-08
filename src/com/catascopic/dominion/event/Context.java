package com.catascopic.dominion.event;

import com.catascopic.dominion.Player;

public interface Context {

	Player owner();

	boolean inPlay();

	boolean inHand();

}
