package com.catascopic.dominion.event;

import com.catascopic.dominion.Source;

public interface Trigger extends Source {

	void resolve();
	
}
