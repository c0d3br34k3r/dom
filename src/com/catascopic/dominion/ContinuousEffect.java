package com.catascopic.dominion;

public interface ContinuousEffect {

	int timestamp();

	Layer layer();

	void handle();

}
