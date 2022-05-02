package com.sbnz.crcalculator.facts;

public class Die {
	private String name;
	private Double averageRoll;
	
	public Die() { }
	
	public Die(String name, Double averageRoll) {
		super();
		this.name = name;
		this.averageRoll = averageRoll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAverageRoll() {
		return averageRoll;
	}

	public void setAverageRoll(Double averageRoll) {
		this.averageRoll = averageRoll;
	}
	
}
