package com.sbnz.crcalculator.facts;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.definition.type.PropertyReactive;

@PropertyReactive
public class Monster {
	private String name;
	private MonsterSize size;
	private Ability strength;
	private Ability dexterity;
	private Ability constitution;
	private Ability intelligence;
	private Ability wisdom;
	private Ability charisma;
	private Double challengeRating;
	private Integer proficiencyBonus;
	private Integer armorClass;
	private Integer numberOfHitDice;
	private Die hitDie;
	private Integer averageHitPoints;
	private List<Action> actions = new ArrayList<>();
	private Double offensiveChallengeRating;
	private Double defensiveChallengeRating;
	
	public Monster() { }

	public Monster(String name, MonsterSize size, Ability strength, Ability dexterity, Ability constitution,
			Ability intelligence, Ability wisdom, Ability charisma, Double challengeRating, Integer proficiencyBonus,
			Integer armorClass, Integer numberOfHitDice, Die hitDie, Integer averageHitPoints, List<Action> actions,
			Double offensiveChallengeRating, Double defensiveChallengeRating) {
		super();
		this.name = name;
		this.size = size;
		this.strength = strength;
		this.dexterity = dexterity;
		this.constitution = constitution;
		this.intelligence = intelligence;
		this.wisdom = wisdom;
		this.charisma = charisma;
		this.challengeRating = challengeRating;
		this.proficiencyBonus = proficiencyBonus;
		this.armorClass = armorClass;
		this.numberOfHitDice = numberOfHitDice;
		this.hitDie = hitDie;
		this.averageHitPoints = averageHitPoints;
		this.actions = actions;
		this.offensiveChallengeRating = offensiveChallengeRating;
		this.defensiveChallengeRating = defensiveChallengeRating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MonsterSize getSize() {
		return size;
	}

	public void setSize(MonsterSize size) {
		this.size = size;
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

	public Double getChallengeRating() {
		return challengeRating;
	}

	public void setChallengeRating(Double challengeRating) {
		this.challengeRating = challengeRating;
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

	public Integer getNumberOfHitDice() {
		return numberOfHitDice;
	}

	public void setNumberOfHitDice(Integer numberOfHitDice) {
		this.numberOfHitDice = numberOfHitDice;
	}

	public Die getHitDie() {
		return hitDie;
	}

	public void setHitDie(Die hitDie) {
		this.hitDie = hitDie;
	}

	public Integer getAverageHitPoints() {
		return averageHitPoints;
	}

	public void setAverageHitPoints(Integer averageHitPoints) {
		this.averageHitPoints = averageHitPoints;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public Double getOffensiveChallengeRating() {
		return offensiveChallengeRating;
	}

	public void setOffensiveChallengeRating(Double offensiveChallengeRating) {
		this.offensiveChallengeRating = offensiveChallengeRating;
	}

	public Double getDefensiveChallengeRating() {
		return defensiveChallengeRating;
	}

	public void setDefensiveChallengeRating(Double defensiveChallengeRating) {
		this.defensiveChallengeRating = defensiveChallengeRating;
	}
	
}
