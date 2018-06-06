package com.catascopic.dominion;

import com.catascopic.dominion.event.Event;
import com.catascopic.dominion.modify.ContinuousEffects;

public interface Abilities {

	void play(Player player, Activation activation);

	void trigger(Event event);

	void getContinuousEffects(ContinuousEffects effects);

}
