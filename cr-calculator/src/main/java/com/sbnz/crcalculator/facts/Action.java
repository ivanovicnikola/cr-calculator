package com.sbnz.crcalculator.facts;

import java.util.ArrayList;
import java.util.List;

public class Action {
	private List<Attack> attacks = new ArrayList<>();
	
	public Action() { }

	public Action(List<Attack> attacks) {
		super();
		this.attacks = attacks;
	}

	public List<Attack> getAttacks() {
		return attacks;
	}

	public void setAttacks(List<Attack> attacks) {
		this.attacks = attacks;
	}

	public Integer getAverageDamage() {
		return attacks.stream().mapToInt(attack -> attack.getAverageDamage()).sum();
	}
	
}
