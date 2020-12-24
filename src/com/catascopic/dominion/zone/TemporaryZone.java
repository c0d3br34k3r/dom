package com.catascopic.dominion.zone;

import java.util.List;

import com.catascopic.dominion.Card;

public class TemporaryZone extends UnorderedZone implements AutoCloseable {

	public TemporaryZone() {}

	TemporaryZone(List<Card> cards) {
		contents.addAll(cards);
	}

	@Override
	public void close() {
		if (!contents.isEmpty()) {
			throw new IllegalStateException(
					this + " contains " + contents);
		}
	}

	@Override
	protected void finalize() throws Throwable {
		close();
	}

}
