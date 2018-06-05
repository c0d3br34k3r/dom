package com.catascopic.dominion.zone;

import java.util.Collection;

import com.catascopic.dominion.Card;

public abstract class Zone {

	Zone() {}

	abstract Collection<Card> removeAll();

	abstract void dump(Zone zone);

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
