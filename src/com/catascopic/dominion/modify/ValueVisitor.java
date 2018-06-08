package com.catascopic.dominion.modify;

public interface ValueVisitor {

	void modifyCost(CostValue value);

	void modifyName(NameValue value);

	void modifyTypes(TypesValue value);
	
	void modifyAttackablePlayers(AttackablePlayersValue value);

	void modifyAbilities(AbilitiesValue value);

}
