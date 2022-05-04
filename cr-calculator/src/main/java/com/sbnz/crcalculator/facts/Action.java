package com.sbnz.crcalculator.facts;

import java.util.ArrayList;
import java.util.List;

public class Action {
	private List<Attack> attacks = new ArrayList<>();
	private Integer averageDamage;
	
	public Action() { }

	public Action(List<Attack> attacks, Integer averageDamage) {
		super();
		this.attacks = attacks;
		this.averageDamage = averageDamage;
	}

	public List<Attack> getAttacks() {
		return attacks;
	}

	public void setAttacks(List<Attack> attacks) {
		this.attacks = attacks;
	}

	public Integer getAverageDamage() {
		return averageDamage;
	}

	public void setAverageDamage(Integer averageDamage) {
		this.averageDamage = averageDamage;
	}
}
