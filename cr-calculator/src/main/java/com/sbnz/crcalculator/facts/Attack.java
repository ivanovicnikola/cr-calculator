package com.sbnz.crcalculator.facts;

public class Attack {
	private String name;
	private Integer numberPerRound;
	private Integer attackBonus;
	private DamageUnit baseDamage;
	private Integer damageBonus;
	private AbilityName relevantAbility;
	private Integer averageDamage;
	
	public Attack() { }

	public Attack(String name, Integer numberPerRound, Integer attackBonus, DamageUnit baseDamage, Integer damageBonus,
			AbilityName relevantAbility, Integer averageDamage) {
		super();
		this.name = name;
		this.numberPerRound = numberPerRound;
		this.attackBonus = attackBonus;
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

	public Integer getNumberPerRound() {
		return numberPerRound;
	}

	public void setNumberPerRound(Integer numberPerRound) {
		this.numberPerRound = numberPerRound;
	}

	public Integer getAttackBonus() {
		return attackBonus;
	}

	public void setAttackBonus(Integer attackBonus) {
		this.attackBonus = attackBonus;
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
