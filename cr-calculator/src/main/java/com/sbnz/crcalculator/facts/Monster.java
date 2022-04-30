package com.sbnz.crcalculator.facts;

public class Monster {
	private String name;
	private Ability strength;
	private Ability dexterity;
	private Ability constitution;
	private Ability intelligence;
	private Ability wisdom;
	private Ability charisma;
	private double expectedChallengeRating;
	private int proficiencyBonus;
	private int armorClass;
	private int numberOfHitDice;
	private Die hitDie;
	
	public Monster() { }
	
	public Monster(String name, Ability strength, Ability dexterity, Ability constitution, Ability intelligence,
			Ability wisdom, Ability charisma, double expectedChallengeRating, int proficiencyBonus, int armorClass,
			int numberOfHitDice, Die hitDie) {
		super();
		this.name = name;
		this.strength = strength;
		this.dexterity = dexterity;
		this.constitution = constitution;
		this.intelligence = intelligence;
		this.wisdom = wisdom;
		this.charisma = charisma;
		this.expectedChallengeRating = expectedChallengeRating;
		this.proficiencyBonus = proficiencyBonus;
		this.armorClass = armorClass;
		this.numberOfHitDice = numberOfHitDice;
		this.hitDie = hitDie;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Ability getStrength() {
		return strength;
	}

	public void setStrength(Ability strength) {
		this.strength = strength;
	}

	public Ability getDexterity() {
		return dexterity;
	}

	public void setDexterity(Ability dexterity) {
		this.dexterity = dexterity;
	}

	public Ability getConstitution() {
		return constitution;
	}

	public void setConstitution(Ability constitution) {
		this.constitution = constitution;
	}

	public Ability getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(Ability intelligence) {
		this.intelligence = intelligence;
	}

	public Ability getWisdom() {
		return wisdom;
	}

	public void setWisdom(Ability wisdom) {
		this.wisdom = wisdom;
	}

	public Ability getCharisma() {
		return charisma;
	}

	public void setCharisma(Ability charisma) {
		this.charisma = charisma;
	}

	public double getExpectedChallengeRating() {
		return expectedChallengeRating;
	}

	public void setExpectedChallengeRating(double expectedChallengeRating) {
		this.expectedChallengeRating = expectedChallengeRating;
	}

	public int getProficiencyBonus() {
		return proficiencyBonus;
	}

	public void setProficiencyBonus(int proficiencyBonus) {
		this.proficiencyBonus = proficiencyBonus;
	}

	public int getArmorClass() {
		return armorClass;
	}

	public void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
	}

	public int getAverageHitPoints() {
		return (int) (numberOfHitDice*(hitDie.getAverageRoll() + constitution.getAbilityModifier()));
	}

	public int getNumberOfHitDice() {
		return numberOfHitDice;
	}

	public void setNumberOfHitDice(int numberOfHitDice) {
		this.numberOfHitDice = numberOfHitDice;
	}

	public Die getHitDie() {
		return hitDie;
	}

	public void setHitDie(Die hitDie) {
		this.hitDie = hitDie;
	}
	
}
