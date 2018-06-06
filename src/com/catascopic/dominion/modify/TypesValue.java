package com.catascopic.dominion.modify;

import java.util.EnumSet;
import java.util.Set;

import com.catascopic.dominion.Card;
import com.catascopic.dominion.Type;

public class TypesValue extends CardValue<Set<Type>> {

	private Set<Type> types;
	private Set<Type> add = EnumSet.noneOf(Type.class);

	public TypesValue(Card card, Set<Type> types) {
		super(card);
		this.types = EnumSet.copyOf(types);
	}

	@Override
	public void handle(ValueVisitor visitor) {
		visitor.modifyTypes(this);
	}

	public void addType(Type type) {
		add.add(type);
	}

	public void addTypes(Set<Type> types) {
		add.addAll(types);
	}

	public void set(Set<Type> baseTypes) {
		types = baseTypes;
	}

	@Override
	public Set<Type> get() {
		types.addAll(add);
		return types;
	}

}
