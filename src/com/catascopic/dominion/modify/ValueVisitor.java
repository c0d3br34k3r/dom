package com.catascopic.dominion.modify;

public interface ValueVisitor {

	void modifyCost(CostValue cost);

	void modifyName(NameValue name);

	void modifyTypes(TypesValue types);

	// Top layer
	void modifyAbilities(AbilitiesValue abilities);

}
