package com.sbnz.crcalculator.facts;

public class Ability {
	private int abilityScore;
	private int abilityModifier;
	
	public Ability() { }
	
	public Ability(int abilityScore, int abilityModifier) {
		super();
		this.abilityScore = abilityScore;
		this.abilityModifier = abilityModifier;
	}

	public int getAbilityScore() {
		return abilityScore;
	}

	public void setAbilityScore(int abilityScore) {
		this.abilityScore = abilityScore;
	}

	public int getAbilityModifier() {
		return abilityModifier;
	}

	public void setAbilityModifier(int abilityModifier) {
		this.abilityModifier = abilityModifier;
	}
}
