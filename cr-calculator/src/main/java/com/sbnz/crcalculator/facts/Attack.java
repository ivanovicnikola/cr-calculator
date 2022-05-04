package com.sbnz.crcalculator.facts;

public class Attack {
	private String name;
	private AttackRangeType rangeType;
	private Integer attackBonus;
	private Integer reach;
	private DamageUnit baseDamage;
	private Integer damageBonus;
	private AbilityName relevantAbility;
	private Integer averageDamage;
	
	public Attack() { }

	public Attack(String name, AttackRangeType rangeType, Integer attackBonus, Integer reach, DamageUnit baseDamage,
			Integer damageBonus, AbilityName relevantAbility, Integer averageDamage) {
		super();
		this.name = name;
		this.rangeType = rangeType;
		this.attackBonus = attackBonus;
		this.reach = reach;
		this.baseDamage = baseDamage;
		this.damageBonus = damageBonus;
		this.relevantAbility = relevantAbility;
		this.averageDamage = averageDamage;
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

	public AbilityName getRelevantAbility() {
		return relevantAbility;
	}

	public void setRelevantAbility(AbilityName relevantAbility) {
		this.relevantAbility = relevantAbility;
	}

	public Integer getAverageDamage() {
		return averageDamage;
	}

	public void setAverageDamage(Integer averageDamage) {
		this.averageDamage = averageDamage;
	}
}
