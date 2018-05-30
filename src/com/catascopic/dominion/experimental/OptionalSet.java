package com.catascopic.dominion.experimental;

import java.util.AbstractSet;
import java.util.Collections;
import java.util.Iterator;

import com.google.common.collect.Iterators;

public abstract class OptionalSet<E> extends AbstractSet<E> {

	public static <E> OptionalSet<E> of(final E element) {
		return new OptionalSet<E>() {

			@Override
			public Iterator<E> iterator() {
				return Iterators.singletonIterator(element);
			}

			@Override
			public boolean isEmpty() {
				return false;
			}

			@Override
			public int size() {
				return 1;
			}

			@Override
			public boolean contains(Object o) {
				return element.equals(o);
			}

			@Override
			public E getOnly() {
				return element;
			}
		};
	}

	public static <E> OptionalSet<E> empty() {
		@SuppressWarnings("unchecked")
		OptionalSet<E> cast = (OptionalSet<E>) EMPTY;
		return cast;
	}

	private static final OptionalSet<?> EMPTY = new OptionalSet<Object>() {

		@Override
		public Iterator<Object> iterator() {
			return Collections.emptyIterator();
		}

		@Override
		public boolean isEmpty() {
			return true;
		}

		@Override
		public int size() {
			return 0;
		}

		@Override
		public boolean contains(Object o) {
			return false;
		}

		@Override
		public Object getOnly() {
			throw new IllegalStateException();
		}
	};

	public abstract E getOnly();

}
