package com.catascopic.dominion.modify;

public interface Value<E> {

	void handle(ValueVisitor visitor);

	E get();

}
