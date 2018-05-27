package com.catascopic.dominion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.AbstractIterator;

public class AutoRemovingGroup<E extends AutoRemovable> implements Iterable<E> {

	public AutoRemovingGroup() {}

	/* LinkedList is superior for removing items during iteration, but this list
	 * will rarely contain more than a few items */
	private List<E> items = new ArrayList<>();

	public void add(E item) {
		items.add(item);
	}

	@Override
	public Iterator<E> iterator() {
		final Iterator<E> iterator = items.iterator();
		return new AbstractIterator<E>() {

			@Override
			protected E computeNext() {
				while (iterator.hasNext()) {
					E next = iterator.next();
					if (!next.isRemoved()) {
						return next;
					}
					iterator.remove();
				}
				return endOfData();
			}
		};
	}

}
