package com.catascopic.dominion.zone;

public class TemporaryZone extends UnorderedZone implements AutoCloseable {

	@Override
	public void close() {
		if (!contents.isEmpty()) {
			throw new IllegalStateException(
					this + " contains " + contents.toString());
		}
	}

}
