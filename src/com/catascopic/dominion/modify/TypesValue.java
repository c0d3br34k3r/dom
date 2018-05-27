package com.catascopic.dominion.modify;

import java.util.EnumSet;
import java.util.Set;

import com.catascopic.dominion.Card;
import com.catascopic.dominion.Type;

public class TypesValue extends CardValue<Set<Type>> {

	private Set<Type> types;

	public TypesValue(Card card, Set<Type> types) {
		super(card);
		this.types = EnumSet.copyOf(types);
	}

	@Override
	public void handle(ValueVisitor visitor) {
		visitor.modifyTypes(this);
	}

	public void addType(Type type) {
		types.add(type);
	}

	public void addTypes(Set<Type> types) {
		types.addAll(types);
	}

	@Override
	public Set<Type> get() {
		return types;
	}

}
