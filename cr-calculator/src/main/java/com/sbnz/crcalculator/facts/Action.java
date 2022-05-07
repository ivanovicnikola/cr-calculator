package com.sbnz.crcalculator.facts;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Action {
	private List<Attack> attacks = new ArrayList<>();
	private boolean processed;
	
	public Action() { }

	public Action(List<Attack> attacks, boolean processed) {
		super();
		this.attacks = attacks;
		this.processed = processed;
	}

	public List<Attack> getAttacks() {
		return attacks;
	}

	public void setAttacks(List<Attack> attacks) {
		this.attacks = attacks;
	}
	
	public boolean isProcessed() {
		return processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}

	public Integer getAverageDamage() {
		return attacks.stream().mapToInt(attack -> attack.getAverageDamage()).sum();
	}
	
	public Integer getMostCommonAttackBonus() {
		return attacks
        .stream()
        .collect(Collectors.groupingBy(Attack::getAttackBonus, Collectors.counting()))
        .entrySet()
        .stream()
        .max(Comparator.comparing(Entry::getValue))
        .map(Map.Entry::getKey).orElse(null);
	}
}
