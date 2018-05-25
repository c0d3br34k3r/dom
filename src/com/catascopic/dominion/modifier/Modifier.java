package com.catascopic.dominion.modifier;

import java.util.Set;

import com.catascopic.dominion.Type;

public interface Modifier {

	int modify(int cost);

	Set<Type> modify(Set<Type> types);

}
