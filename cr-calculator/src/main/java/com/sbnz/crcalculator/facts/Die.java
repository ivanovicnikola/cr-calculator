package com.sbnz.crcalculator.facts;

public class Die {
	private String name;
	private double averageRoll;
	
	public Die() { }
	
	public Die(String name, double averageRoll) {
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

	public double getAverageRoll() {
		return averageRoll;
	}

	public void setAverageRoll(double averageRoll) {
		this.averageRoll = averageRoll;
	}
	
}
