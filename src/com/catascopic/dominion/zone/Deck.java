package com.catascopic.dominion.zone;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.catascopic.dominion.Card;
import com.google.common.base.Predicate;

public class Deck extends OrderedZone {

	public SingleSelection selectTop() {
		return ensureSize(1) == 1
				? new SingleSelection(locateTop())
				: Selection.empty();
	}

	public Selection selectTop(int amount) {
		return new Selection(locateTop(ensureSize(amount)));
	}

	// TODO: visibility
	public TemporaryZone revealTop(int amount) {
		return lookAtTop(amount);
	}

	public TemporaryZone lookAtTop(int amount) {
		List<Card> top = contents.subList(0, ensureSize(amount));
		TemporaryZone temp = new TemporaryZone(top);
		top.clear();
		topCount++;
		return temp;
	}

	public TemporaryZone revealUntil(Predicate<Card> filter) {
		return revealUntil(filter, 1);
	}

	public TemporaryZone revealUntil(Predicate<Card> filter, int amount) {
		int i;
		int matches = 0;
		for (i = 0; ensureSize(i) == i && matches < amount; i++) {
			if (filter.apply(contents.get(i))) {
				matches++;
			}
		}
		return revealTop(i);
	}

	private int ensureSize(int amount) {
		if (contents.size() < amount) {
			contents.addAll(player.discardPile().recycle());
		}
		return contents.size();
	}

	Collection<Card> dump() {
		if (contents.isEmpty()) {
			return Collections.emptySet();
		}
		for (Card card : contents) {
			card.location().move();
		}
		Collection<Card> result = new ArrayList<>(contents);
		contents.clear();
		topCount++;
		return result;
	}

}
