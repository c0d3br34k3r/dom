package com.catascopic.dominion.event;

public interface EventVisitor {

	void handleTrash(TrashEvent event, Context context);

	void handleGain(GainEvent event, Context context);

	void handlePlay(PlayEvent playEvent, Context context);

}
