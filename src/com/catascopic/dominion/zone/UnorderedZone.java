package com.catascopic.dominion.zone;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.catascopic.dominion.Card;
import com.google.common.collect.Iterables;

public class UnorderedZone extends Zone implements Selectable {

	protected Set<Card> contents;

	@Override
	public Set<Card> cards() {
		return Collections.unmodifiableSet(contents);
	}

	@Override
	Collection<Card> removeAll() {
		for (Card card : contents) {
			card.location().move();
		}
		contents.clear();
		List<Card> result = new ArrayList<>(contents);
		return result;
	}

	@Override
	public void dump(Zone zone) {
		contents.addAll(zone.removeAll());
	}

	public void accept(Selection selection) {
		selection.move(new Selection.Acceptor() {

			@Override
			public Locator accept(Collection<Card> removed) {
				contents.addAll(removed);
				return locate(removed);
			}
		});
	}

	@Override
	public SingleSelection select(Card card) {
		return new SingleSelection(locate(card));
	}

	@Override
	public Selection select(Collection<Card> cards) {
		return new Selection(locate(cards));
	}

	@Override
	public Selection selectAll() {
		return select(cards());
	}

	Locator locate(Collection<Card> cards) {
		switch (cards.size()) {
		case 0:
			return Selection.EMPTY_LOCATOR;
		case 1:
			return locate(Iterables.getOnlyElement(cards));
		default:
		}
		final List<Locator> locators = new ArrayList<>();
		for (Card card : cards) {
			locators.add(locate(card));
		}
		return new Locator() {

			@Override
			public void remove(Collection<Card> cards) {
				for (Locator locator : locators) {
					locator.remove(cards);
				}
			}
		};
	}

	Locator locate(final Card card) {
		final int currentMoveCount = card.location().moveCount();
		return new Locator() {

			@Override
			public void remove(Collection<Card> removed) {
				if (card.location().moveCount() == currentMoveCount) {
					card.location().move();
					contents.remove(card);
					removed.add(card);
				}
			}
		};
	}

}
