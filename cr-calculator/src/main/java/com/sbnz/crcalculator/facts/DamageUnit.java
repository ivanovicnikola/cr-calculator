package com.sbnz.crcalculator.facts;

public class DamageUnit {
	private Integer numberOfDice;
	private Die die;
	private DamageType damageType;
	
	public DamageUnit() { }
	
	public DamageUnit(Integer numberOfDice, Die die, DamageType damageType) {
		super();
		this.numberOfDice = numberOfDice;
		this.die = die;
		this.damageType = damageType;
	}

	public Integer getNumberOfDice() {
		return numberOfDice;
	}

	public void setNumberOfDice(Integer numberOfDice) {
		this.numberOfDice = numberOfDice;
	}

	public Die getDie() {
		return die;
	}

	public void setDie(Die die) {
		this.die = die;
	}

	public DamageType getDamageType() {
		return damageType;
	}

	public void setDamageType(DamageType damageType) {
		this.damageType = damageType;
	}
	
	public Integer getAverageValue() {
		return (int) (numberOfDice*die.getAverageRoll());
	}
}
