package com.catascopic.dominion.zone;

import java.util.ArrayList;
import java.util.List;

import com.catascopic.dominion.Card;

public class MultiSelection extends Selection {

	private List<Selection> selections;

	@Override
	List<Card> remove() {
		List<Card> cards = new ArrayList<>();
		for (Selection selection : selections) {
			cards.addAll(selection.remove());
		}
		return cards;
	}

}
