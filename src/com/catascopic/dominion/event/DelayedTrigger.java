package com.catascopic.dominion.event;

import com.catascopic.dominion.Source;

public interface DelayedTrigger extends Source {

	boolean triggers(Context context, Event event);
	
	void effect();
	
}
