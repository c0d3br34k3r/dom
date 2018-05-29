package com.catascopic.dominion.index;

import java.util.AbstractSet;
import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class IndexSet<E extends Indexed> extends AbstractSet<E> {

	private BitSet elements = new BitSet();
	private int size = 0;
	private List<E> universe;

	IndexSet(List<E> universe) {
		this.universe = universe;
	}

	@Override
	public Iterator<E> iterator() {
		return this.new IndexSetIterator();
	}

	private class IndexSetIterator implements Iterator<E> {

		int prev = -1;
		int next = elements.nextSetBit(0);

		@Override
		public boolean hasNext() {
			return next != -1;
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			prev = next;
			next = elements.nextSetBit(next + 1);
			return universe.get(next);
		}

		@Override
		public void remove() {
			if (prev == -1) {
				throw new IllegalStateException();
			}
			elements.clear(prev);
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		int ordinal = ((Indexed) o).ordinal();
		if (!elements.get(ordinal)) {
			elements.set(ordinal);
			size++;
			return true;
		}
		return false;
	}

	@Override
	public boolean add(E o) {
		int ordinal = o.ordinal();
		if (!elements.get(ordinal)) {
			elements.set(ordinal);
			size++;
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(Object e) {
		int ordinal = ((Indexed) e).ordinal();
		boolean result = elements.get(ordinal);
		elements.clear(ordinal);
		return result;
	}

	// Bulk Operations

	@Override
	public boolean containsAll(Collection<?> c) {
		if (!(c instanceof IndexSet)) {
			return super.containsAll(c);
		}
		IndexSet<?> other = (IndexSet<?>) c;
		BitSet copy = new BitSet();
		copy.or(other.elements);
		copy.and(elements);
		return copy.equals(other.elements);
	}

	@Override
	public boolean addAll(Collection<? extends E> collection) {
		if (!(collection instanceof IndexSet)) {
			return super.addAll(collection);
		}
		IndexSet<?> other = (IndexSet<?>) collection;
		elements.or(other.elements);
		return recalculateSize();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		if (!(c instanceof IndexSet)) {
			return super.removeAll(c);
		}
		IndexSet<?> other = (IndexSet<?>) c;
		elements.andNot(other.elements);
		return recalculateSize();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		if (!(c instanceof IndexSet)) {
			return super.removeAll(c);
		}
		IndexSet<?> other = (IndexSet<?>) c;
		elements.and(other.elements);
		return recalculateSize();
	}

	private boolean recalculateSize() {
		int oldSize = size;
		size = elements.cardinality();
		return size != oldSize;
	}

	@Override
	public void clear() {
		elements.clear();
		size = 0;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof IndexSet)) {
			return super.equals(o);
		}
		return elements.equals(((IndexSet<?>) o).elements);
	}

}
