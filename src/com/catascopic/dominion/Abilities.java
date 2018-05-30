package com.catascopic.dominion;

import com.catascopic.dominion.event.Context;
import com.catascopic.dominion.event.Event;
import com.catascopic.dominion.event.Triggers;
import com.catascopic.dominion.modify.ContinuousEffects;

public interface Abilities {

	void play(Player player, Activation activation);

	void trigger(Context context, Event event, Triggers triggers);

	void continuousEffect(Context context, ContinuousEffects effects);

}
