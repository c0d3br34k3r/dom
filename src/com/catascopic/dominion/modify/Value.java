package com.catascopic.dominion.modify;

public abstract class Value<E> {

	public Value() {}

	public abstract void handle(ValueVisitor visitor);

	public abstract E get();

}
