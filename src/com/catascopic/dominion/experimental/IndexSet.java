package com.catascopic.dominion.experimental;

import java.util.AbstractSet;
import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class IndexSet<E extends Indexed> extends AbstractSet<E> {

	private BitSet bits = new BitSet();
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
		int next = bits.nextSetBit(0);

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
			next = bits.nextSetBit(next + 1);
			return universe.get(next);
		}

		@Override
		public void remove() {
			if (prev == -1) {
				throw new IllegalStateException();
			}
			bits.clear(prev);
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
		if (!bits.get(ordinal)) {
			bits.set(ordinal);
			size++;
			return true;
		}
		return false;
	}

	@Override
	public boolean add(E o) {
		int ordinal = o.ordinal();
		if (!bits.get(ordinal)) {
			bits.set(ordinal);
			size++;
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(Object e) {
		int ordinal = ((Indexed) e).ordinal();
		boolean result = bits.get(ordinal);
		bits.clear(ordinal);
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
		copy.or(other.bits);
		copy.and(bits);
		return copy.equals(other.bits);
	}

	@Override
	public boolean addAll(Collection<? extends E> collection) {
		if (!(collection instanceof IndexSet)) {
			return super.addAll(collection);
		}
		IndexSet<?> other = (IndexSet<?>) collection;
		bits.or(other.bits);
		return recalculateSize();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		if (!(c instanceof IndexSet)) {
			return super.removeAll(c);
		}
		IndexSet<?> other = (IndexSet<?>) c;
		bits.andNot(other.bits);
		return recalculateSize();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		if (!(c instanceof IndexSet)) {
			return super.removeAll(c);
		}
		IndexSet<?> other = (IndexSet<?>) c;
		bits.and(other.bits);
		return recalculateSize();
	}

	private boolean recalculateSize() {
		int oldSize = size;
		size = bits.cardinality();
		return size != oldSize;
	}

	@Override
	public void clear() {
		bits.clear();
		size = 0;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof IndexSet)) {
			return super.equals(o);
		}
		return bits.equals(((IndexSet<?>) o).bits);
	}

}
