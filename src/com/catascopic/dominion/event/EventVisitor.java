package com.catascopic.dominion.event;

public interface EventVisitor {

	void handleTrash(TrashEvent event);

	void handleGain(GainEvent event);

}
