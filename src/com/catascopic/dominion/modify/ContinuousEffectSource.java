package com.catascopic.dominion.modify;

public interface ContinuousEffectSource {

	int timestamp();

	void getContinuousEffectsLayer1(ContinuousEffects effects);

	void getContinuousEffectsLayer2(ContinuousEffects effects);

}
