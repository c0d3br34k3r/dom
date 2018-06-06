package com.catascopic.dominion.modify;

public interface ContinuousEffectSource {

	int timestamp();

	Layer layer();

	void getContinuousEffects(ContinuousEffects effects);

}
