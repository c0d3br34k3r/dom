package com.catascopic.dominion.modify;

public interface ContinuousEffect {

	 int timestamp();

	// Layer layer();

	void modify(Value<?> value);

}
