package com.sbnz.crcalculator.facts;

public class Ability {
	private Integer abilityScore;
	private Integer abilityModifier;
	
	public Ability() { }

	public Ability(Integer abilityScore, Integer abilityModifier) {
		super();
		this.abilityScore = abilityScore;
		this.abilityModifier = abilityModifier;
	}

	public Integer getAbilityScore() {
		return abilityScore;
	}

	public void setAbilityScore(Integer abilityScore) {
		this.abilityScore = abilityScore;
	}

	public Integer getAbilityModifier() {
		return abilityModifier;
	}

	public void setAbilityModifier(Integer abilityModifier) {
		this.abilityModifier = abilityModifier;
	}
}
