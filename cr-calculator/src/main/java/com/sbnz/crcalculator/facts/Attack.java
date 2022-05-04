package com.sbnz.crcalculator.facts;

import java.util.List;

public class Attack {
	private String name;
	private AttackRangeType rangeType;
	private Integer attackBonus;
	private Integer reach;
	private DamageUnit baseDamage;
	private Integer damageBonus;
	private List<DamageUnit> additionalDamage;
	private AbilityName relevantAbility;
	
	public Attack() { }

	public Attack(String name, AttackRangeType rangeType, Integer attackBonus, Integer reach, DamageUnit baseDamage,
			Integer damageBonus, List<DamageUnit> additionalDamage, AbilityName relevantAbility) {
		super();
		this.name = name;
		this.rangeType = rangeType;
		this.attackBonus = attackBonus;
		this.reach = reach;
		this.baseDamage = baseDamage;
		this.damageBonus = damageBonus;
		this.additionalDamage = additionalDamage;
		this.relevantAbility = relevantAbility;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AttackRangeType getRangeType() {
		return rangeType;
	}

	public void setRangeType(AttackRangeType rangeType) {
		this.rangeType = rangeType;
	}

	public Integer getAttackBonus() {
		return attackBonus;
	}

	public void setAttackBonus(Integer attackBonus) {
		this.attackBonus = attackBonus;
	}

	public Integer getReach() {
		return reach;
	}

	public void setReach(Integer reach) {
		this.reach = reach;
	}

	public DamageUnit getBaseDamage() {
		return baseDamage;
	}

	public void setBaseDamage(DamageUnit baseDamage) {
		this.baseDamage = baseDamage;
	}

	public Integer getDamageBonus() {
		return damageBonus;
	}

	public void setDamageBonus(Integer damageBonus) {
		this.damageBonus = damageBonus;
	}

	public List<DamageUnit> getAdditionalDamage() {
		return additionalDamage;
	}

	public void setAdditionalDamage(List<DamageUnit> additionalDamage) {
		this.additionalDamage = additionalDamage;
	}

	public AbilityName getRelevantAbility() {
		return relevantAbility;
	}

	public void setRelevantAbility(AbilityName relevantAbility) {
		this.relevantAbility = relevantAbility;
	}
}
