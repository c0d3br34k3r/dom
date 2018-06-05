package com.catascopic.dominion.zone;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.catascopic.dominion.Card;
import com.catascopic.dominion.Player;
import com.catascopic.dominion.base.TemporaryZone;
import com.catascopic.dominion.zone.Selection.Acceptor;

public class Deck extends Zone {

	private List<Card> contents = new ArrayList<>();
	private Player player;
	private int topCount;

	public void moveToTop(Selection selection) {
		selection.move(new Acceptor() {

			@Override
			public Locator accept(Collection<Card> removed) {
				if (contents.addAll(removed)) {
					topCount++;
				}
				return lockTop(removed.size());
			}
		});
	}

	public void shuffle() {
		Collections.shuffle(contents);
		topCount++;
	}

	public SingleSelection selectTop() {
		return ensureSize(1) == 1
				? new SingleSelection(locateTop())
				: Selection.empty();
	}

	public Selection selectTop(int amount) {
		return new Selection(lockTop(ensureSize(amount)));
	}

	Locator lockTop(final int amount) {
		final int currentTopCount = topCount;
		return new Locator() {

			@Override
			public void remove(Collection<Card> removed) {
				if (topCount == currentTopCount) {
					List<Card> cards = contents.subList(
							contents.size() - amount,
							contents.size());
					for (Card card : cards) {
						card.location().move();
					}
					topCount++;
					removed.addAll(cards);
					cards.clear();
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
					Card card = contents.remove(contents.size() - 1);
					card.location().move();
					topCount++;
					removed.add(card);
				}
			}
		};
	}

	private int ensureSize(int amount) {
		if (contents.size() < amount) {
			dump(player.discardPile());
		}
		shuffle();
		return contents.size();
	}

	@Override
	void dump(Zone zone) {
		contents.addAll(zone.removeAll());
	}

	@Override
	Collection<Card> removeAll() {
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

	public TemporaryZone lookAtTop(int amount) {
		// TODO Auto-generated method stub
		return null;
	}

}
