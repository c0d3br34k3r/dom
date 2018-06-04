package com.catascopic.dominion.zone;

import java.util.List;

import com.catascopic.dominion.Card;

public abstract class Selection {

	abstract List<Card> remove();

	static final Locator LOST_TRACK = new Locator() {

		@Override
		public boolean remove() {
			return false;
		}
	};

}
