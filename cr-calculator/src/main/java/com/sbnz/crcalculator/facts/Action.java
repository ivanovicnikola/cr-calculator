package com.sbnz.crcalculator.facts;

import java.util.ArrayList;
import java.util.List;

public class Action {
	private List<Attack> attacks = new ArrayList<>();;
	
	public Action() { }

	public List<Attack> getAttacks() {
		return attacks;
	}

	public void setAttacks(List<Attack> attacks) {
		this.attacks = attacks;
	}
}
