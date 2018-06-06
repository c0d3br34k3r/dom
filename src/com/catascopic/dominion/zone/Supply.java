package com.catascopic.dominion.zone;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;

import com.catascopic.dominion.Card;
import com.catascopic.dominion.PileName;
import com.catascopic.dominion.zone.SingleSelection.SingleAcceptor;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Iterables;

public class Supply extends Zone implements Selectable {

	private Map<PileName, Pile> contents;

	public int emptyPiles() {
		int total = 0;
		for (Pile pile : contents.values()) {
			if (pile.cards.isEmpty()) {
				total++;
			}
		}
		return total;
	}

	public void accept(SingleSelection selection) {
		selection.move(new SingleAcceptor() {

			// TODO
			@Override
			public Locator accept(Card removed) {
				Pile pile = contents.get(removed.pile());
				pile.cards.add(removed);
				pile.topCount++;
				return pile.locate();
			}
		});
	}

	public SingleSelection select(PileName pileName) {
		Pile pile = contents.get(pileName);
		return pile.cards.isEmpty()
				? Selection.empty()
				: new SingleSelection(pile.locate());
	}

	@Override
	public SingleSelection select(Card card) {
		Pile pile = contents.get(card.pile());
		return pile.cards.isEmpty() || !pile.cards.element().equals(card)
				? Selection.empty()
				: new SingleSelection(pile.locate());
	}

	@Deprecated
	@Override
	public Selection select(Collection<Card> cards) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Selection selectAll() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Collection<Card> cards() {
		return new AbstractCollection<Card>() {

			@Override
			public Iterator<Card> iterator() {
				final Iterator<Pile> iterator = contents.values().iterator();
				return new AbstractIterator<Card>() {

					@Override
					protected Card computeNext() {
						while (iterator.hasNext()) {
							Pile next = iterator.next();
							if (!next.cards.isEmpty()) {
								return next.cards.element();
							}
						}
						return endOfData();
					}
				};
			}

			@Override
			public int size() {
				return Iterables.size(this);
			}
		};
	}

	static class Pile {

		private int topCount;
		private Queue<Card> cards;

		private Locator locate() {
			final int currentTopCount = topCount;
			return new Locator() {

				@Override
				public void remove(Collection<Card> removed) {
					if (topCount == currentTopCount) {
						removed.add(cards.remove());
						topCount++;
					}
				}
			};
		}
	}

}
