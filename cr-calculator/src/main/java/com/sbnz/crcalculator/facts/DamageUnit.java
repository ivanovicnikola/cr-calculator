package com.sbnz.crcalculator.facts;

public class DamageUnit {
	private Integer numberOfDice;
	private Die die;
	
	public DamageUnit() { }
	
	public DamageUnit(Integer numberOfDice, Die die) {
		super();
		this.numberOfDice = numberOfDice;
		this.die = die;
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
	
	public Integer getAverageValue() {
		return (int) (numberOfDice*die.getAverageRoll());
	}
}
