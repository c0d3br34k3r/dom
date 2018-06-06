package com.catascopic.dominion.modify;

import com.catascopic.dominion.Card;
import com.catascopic.dominion.Name;

public class NameValue extends CardValue<Name> {

	private Name name;

	public NameValue(Card card, Name name) {
		super(card);
		this.name = name;
	}

	@Override
	public void handle(ValueVisitor visitor) {
		visitor.modifyName(this);
	}

	public void set(Name newName) {
		name = newName;
	}

	@Override
	public Name get() {
		return name;
	}

}
