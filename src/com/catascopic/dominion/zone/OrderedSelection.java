package com.catascopic.dominion.zone;

import java.util.List;

import com.catascopic.dominion.Card;

public abstract class OrderedSelection extends Selection {

	@Override
	abstract List<Card> remove();

}
