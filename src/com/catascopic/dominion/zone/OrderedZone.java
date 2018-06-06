package com.catascopic.dominion.zone;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.catascopic.dominion.Card;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.zone.Selection.Acceptor;
import com.google.common.collect.Lists;

public class OrderedZone extends Zone {

	// Optimized for removing from the top
	protected List<Card> contents = Lists.reverse(new ArrayList<Card>());
	protected int topCount;
	protected Player player;

	public int size() {
		return contents.size();
	}

	public Collection<Card> acceptTop(Selection selection) {
		return selection.move(new Acceptor() {

			@Override
			public Locator accept(Collection<Card> removed) {
				if (contents.addAll(0, removed)) {
					topCount++;
				}
				return locateTop(removed.size());
			}
		});
	}

	Locator locateTop(final int amount) {
		final int currentTopCount = topCount;
		return new Locator() {

			@Override
			public void remove(Collection<Card> removed) {
				if (topCount == currentTopCount) {
					List<Card> top = contents.subList(0, amount);
					for (Card card : top) {
						card.location().move();
					}
					topCount++;
					removed.addAll(top);
					top.clear();
				}
			}
		};
	}

	Locator locateTop() {
		final int currentTopCount = topCount;
		return new Locator() {

			@Override
			public void remove(Collection<Card> removed) {
				if (topCount == currentTopCount) {
					Card card = contents.remove(0);
					card.location().move();
					topCount++;
					removed.add(card);
				}
			}
		};
	}

}
