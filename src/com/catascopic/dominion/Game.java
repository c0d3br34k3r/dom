package com.catascopic.dominion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.catascopic.dominion.event.DelayedTrigger;
import com.catascopic.dominion.modify.ContinuousEffect;
import com.catascopic.dominion.modify.TemporaryContinuousEffect;
import com.catascopic.dominion.modify.Value;
import com.catascopic.dominion.zone.Supply;
import com.catascopic.dominion.zone.UnorderedZone;
import com.google.common.collect.Iterables;

public class Game {

	private int time; // = 0
	private int lastCalculationTime; // = 0
	private List<ContinuousEffect> calculatedEffects = new ArrayList<>();

	private AutoRemovingGroup<TemporaryContinuousEffect> continuousEffects =
			new AutoRemovingGroup<>();

	private List<Player> players;

	public int getTime() {
		return time;
	}

	public <E> E calculate(Value<E> value) {
		if (lastCalculationTime != time) {
			calculateEffects();
		}
		for (ContinuousEffect effect : calculatedEffects) {
			effect.modify(value);
		}
		return value.get();
	}

	private void calculateEffects() {
		calculatedEffects.clear();
		lastCalculationTime = time;
		Iterables.addAll(calculatedEffects, continuousEffects);
		for (Player player : players) {
			calculatedEffects.addAll(player.inPlay().cards());
		}
		Collections.sort(calculatedEffects, TIMESTAMP_ORDER);
	}

	public void addContinuousEffect(
			TemporaryContinuousEffect continuousEffect) {
		continuousEffects.add(continuousEffect);
	}

	public Turn currentTurn() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addDelayedTrigger(DelayedTrigger trigger) {
		// TODO Auto-generated method stub

	}

	public Supply supply() {
		// TODO Auto-generated method stub
		return null;
	}

	public UnorderedZone trash() {
		// TODO Auto-generated method stub
		return null;
	}

	private static final Comparator<? super ContinuousEffect> TIMESTAMP_ORDER =
			new Comparator<ContinuousEffect>() {

				@Override
				public int compare(ContinuousEffect left,
						ContinuousEffect right) {
					return -Integer.compare(
							left.timestamp(),
							right.timestamp());
				}
			};

}
