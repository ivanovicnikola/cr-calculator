package com.sbnz.crcalculator.facts;

public class Attack {
	private AttackType type;
	private Integer numberPerRound;
	private Integer attackBonus;
	private DamageUnit baseDamage;
	private Integer damageBonus;
	private AbilityName relevantAbility;
	
	public Attack() { }

	public Attack(AttackType type, Integer numberPerRound, Integer attackBonus, DamageUnit baseDamage,
			Integer damageBonus, AbilityName relevantAbility) {
		super();
		this.type = type;
		this.numberPerRound = numberPerRound;
		this.attackBonus = attackBonus;
		this.baseDamage = baseDamage;
		this.damageBonus = damageBonus;
		this.relevantAbility = relevantAbility;
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

	public AttackType getType() {
		return type;
	}

	public void setType(AttackType type) {
		this.type = type;
	}

	public Integer getAverageDamage() {
		return (baseDamage.getAverageValue() + damageBonus) * numberPerRound;
	}

	public String bonusString(Integer bonus) {
		return (bonus>0)?"+" + bonus: "" + bonus;
	}
	
	public String getAttackString() {
		return numberPerRound + ((numberPerRound == 1)?" attack":" attacks") + ": " + bonusString(attackBonus) + " to hit. Hit: " + (baseDamage.getAverageValue() + damageBonus) + " (" + baseDamage.getNumberOfDice() + baseDamage.getDie().getName() + bonusString(damageBonus) + ") damage.";
	}
}
