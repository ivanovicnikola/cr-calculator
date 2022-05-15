package com.sbnz.crcalculator.facts;

public class ChallengeRating {
	private Integer ordinal;
	private String value;
	private Integer experiencePoints;
	private Integer proficiencyBonus;
	private Integer armorClass;
	private Integer minHitPoints;
	private Integer maxHitPoints;
	private Integer attackBonus;
	private Integer minDamage;
	private Integer maxDamage;
	
	public ChallengeRating() { }

	public ChallengeRating(Integer ordinal, String value, Integer experiencePoints, Integer proficiencyBonus,
			Integer armorClass, Integer minHitPoints, Integer maxHitPoints, Integer attackBonus, Integer minDamage,
			Integer maxDamage) {
		super();
		this.ordinal = ordinal;
		this.value = value;
		this.experiencePoints = experiencePoints;
		this.proficiencyBonus = proficiencyBonus;
		this.armorClass = armorClass;
		this.minHitPoints = minHitPoints;
		this.maxHitPoints = maxHitPoints;
		this.attackBonus = attackBonus;
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;
	}

	public Integer getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(Integer ordinal) {
		this.ordinal = ordinal;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getExperiencePoints() {
		return experiencePoints;
	}

	public void setExperiencePoints(Integer experiencePoints) {
		this.experiencePoints = experiencePoints;
	}

	public Integer getProficiencyBonus() {
		return proficiencyBonus;
	}

	public void setProficiencyBonus(Integer proficiencyBonus) {
		this.proficiencyBonus = proficiencyBonus;
	}

	public Integer getArmorClass() {
		return armorClass;
	}

	public void setArmorClass(Integer armorClass) {
		this.armorClass = armorClass;
	}

	public Integer getMinHitPoints() {
		return minHitPoints;
	}

	public void setMinHitPoints(Integer minHitPoints) {
		this.minHitPoints = minHitPoints;
	}

	public Integer getMaxHitPoints() {
		return maxHitPoints;
	}

	public void setMaxHitPoints(Integer maxHitPoints) {
		this.maxHitPoints = maxHitPoints;
	}

	public Integer getAttackBonus() {
		return attackBonus;
	}

	public void setAttackBonus(Integer attackBonus) {
		this.attackBonus = attackBonus;
	}

	public Integer getMinDamage() {
		return minDamage;
	}

	public void setMinDamage(Integer minDamage) {
		this.minDamage = minDamage;
	}

	public Integer getMaxDamage() {
		return maxDamage;
	}

	public void setMaxDamage(Integer maxDamage) {
		this.maxDamage = maxDamage;
	}
	
}
