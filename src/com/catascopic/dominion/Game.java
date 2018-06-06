package com.catascopic.dominion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.catascopic.dominion.event.DelayedTrigger;
import com.catascopic.dominion.modify.ContinuousEffect;
import com.catascopic.dominion.modify.ContinuousEffectSource;
import com.catascopic.dominion.modify.ContinuousEffects;
import com.catascopic.dominion.modify.Layer;
import com.catascopic.dominion.modify.TemporaryContinuousEffect;
import com.catascopic.dominion.modify.Value;
import com.catascopic.dominion.zone.Supply;
import com.catascopic.dominion.zone.UnorderedZone;
import com.google.common.collect.Iterables;

public class Game {

	private int time; // = 0
	private int lastCalculationTime; // = 0
	private List<ContinuousEffect> calculatedEffects = new ArrayList<>();

	private AutoRemovingGroup<TemporaryContinuousEffect> temporaryEffects =
			new AutoRemovingGroup<>();

	private List<Player> players = new ArrayList<>();

	void addPlayer(Player player) {
		players.add(player);
	}

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
		List<ContinuousEffectSource> sources = new ArrayList<>();
		Iterables.addAll(sources, temporaryEffects);
		for (Player player : players) {
			sources.addAll(player.inPlay().cards());
		}
		Collections.sort(sources, TIMESTAMP_ORDER);
		ContinuousEffects continuousEffects = new ContinuousEffects() {

			@Override
			public void add(ContinuousEffect effect) {
				calculatedEffects.add(effect);
			}
		};
		for (ContinuousEffectSource source : sources) {
			source.getContinuousEffectsLayer1(continuousEffects);
		}
		for (ContinuousEffectSource source : sources) {
			source.getContinuousEffectsLayer2(continuousEffects);
		}
	}

	public void addContinuousEffect(
			TemporaryContinuousEffect continuousEffect) {
		temporaryEffects.add(continuousEffect);
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

	private static final Comparator<? super ContinuousEffectSource> TIMESTAMP_ORDER =
			new Comparator<ContinuousEffectSource>() {

				@Override
				public int compare(ContinuousEffectSource left,
						ContinuousEffectSource right) {
					return Integer.compare(
							left.timestamp(),
							right.timestamp());
				}
			};

	void tick() {
		time++;
	}

}
