package com.catascopic.dominion.modify;

public interface ContinuousEffect extends Comparable<ContinuousEffect> {

	int timestamp();

	Layer layer();

	void modify(Value<?> value);

}
