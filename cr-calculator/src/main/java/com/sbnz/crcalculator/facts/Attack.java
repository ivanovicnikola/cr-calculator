package com.sbnz.crcalculator.facts;

public class Attack {
	private Integer numberPerRound;
	private Integer attackBonus;
	private DamageUnit baseDamage;
	private Integer damageBonus;
	private AbilityName relevantAbility;
	private String attackBonusMessage;
	
	public Attack() { }

	public Attack(Integer numberPerRound, Integer attackBonus, DamageUnit baseDamage, Integer damageBonus,
			AbilityName relevantAbility, String attackBonusMessage) {
		super();
		this.numberPerRound = numberPerRound;
		this.attackBonus = attackBonus;
		this.baseDamage = baseDamage;
		this.damageBonus = damageBonus;
		this.relevantAbility = relevantAbility;
		this.attackBonusMessage = attackBonusMessage;
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
		return (baseDamage.getAverageValue() + damageBonus) * numberPerRound;
	}

	public String getAttackBonusMessage() {
		return attackBonusMessage;
	}

	public void setAttackBonusMessage(String attackBonusMessage) {
		this.attackBonusMessage = attackBonusMessage;
	}

}
