package com.catascopic.dominion;

import com.catascopic.dominion.modify.Value;

public interface ContinuousEffect {

	int timestamp();

	Layer layer();

	void handle(Value<?> value);

}
