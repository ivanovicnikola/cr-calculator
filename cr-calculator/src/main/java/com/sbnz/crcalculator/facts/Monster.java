package com.sbnz.crcalculator.facts;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.definition.type.PropertyReactive;

@PropertyReactive
public class Monster {
	private MonsterSize size;
	private Ability strength;
	private Ability dexterity;
	private Ability constitution;
	private Ability intelligence;
	private Ability wisdom;
	private Ability charisma;
	private ChallengeRating challengeRating;
	private Integer proficiencyBonus;
	private Integer armorClass;
	private String armorClassMessage;
	private Integer numberOfHitDice;
	private Die hitDie;
	private String hitPointsMessage;
	private List<Action> actions = new ArrayList<>();
	private ChallengeRating offensiveChallengeRating;
	private ChallengeRating defensiveChallengeRating;
	private ChallengeRating expectedChallengeRating;
	
	public Monster() { }

	public Monster(MonsterSize size, Ability strength, Ability dexterity, Ability constitution, Ability intelligence,
			Ability wisdom, Ability charisma, ChallengeRating challengeRating, Integer proficiencyBonus,
			Integer armorClass, String armorClassMessage, Integer numberOfHitDice, Die hitDie, String hitPointsMessage,
			List<Action> actions, ChallengeRating offensiveChallengeRating, ChallengeRating defensiveChallengeRating,
			ChallengeRating expectedChallengeRating) {
		super();
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
		this.armorClassMessage = armorClassMessage;
		this.numberOfHitDice = numberOfHitDice;
		this.hitDie = hitDie;
		this.hitPointsMessage = hitPointsMessage;
		this.actions = actions;
		this.offensiveChallengeRating = offensiveChallengeRating;
		this.defensiveChallengeRating = defensiveChallengeRating;
		this.expectedChallengeRating = expectedChallengeRating;
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

	public ChallengeRating getChallengeRating() {
		return challengeRating;
	}

	public void setChallengeRating(ChallengeRating challengeRating) {
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

	public Integer getHitPointBonus() {
		return constitution.getAbilityModifier() * numberOfHitDice;
	}
	
	public Integer getAverageHitPoints() {
		return (int) (numberOfHitDice * hitDie.getAverageRoll() + getHitPointBonus());
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public ChallengeRating getOffensiveChallengeRating() {
		return offensiveChallengeRating;
	}

	public void setOffensiveChallengeRating(ChallengeRating offensiveChallengeRating) {
		this.offensiveChallengeRating = offensiveChallengeRating;
	}

	public ChallengeRating getDefensiveChallengeRating() {
		return defensiveChallengeRating;
	}

	public void setDefensiveChallengeRating(ChallengeRating defensiveChallengeRating) {
		this.defensiveChallengeRating = defensiveChallengeRating;
	}

	public String getArmorClassMessage() {
		return armorClassMessage;
	}

	public void setArmorClassMessage(String armorClassMessage) {
		this.armorClassMessage = armorClassMessage;
	}

	public String getHitPointsMessage() {
		return hitPointsMessage;
	}

	public void setHitPointsMessage(String hitPointsMessage) {
		this.hitPointsMessage = hitPointsMessage;
	}

	public ChallengeRating getExpectedChallengeRating() {
		return expectedChallengeRating;
	}

	public void setExpectedChallengeRating(ChallengeRating expectedChallengeRating) {
		this.expectedChallengeRating = expectedChallengeRating;
	}

}
