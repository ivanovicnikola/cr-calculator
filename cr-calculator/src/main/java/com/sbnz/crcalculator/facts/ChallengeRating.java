package com.sbnz.crcalculator.facts;

public class ChallengeRating {
	private Integer ordinal;
	private String value;
	private Integer experiencePoints;
	
	public ChallengeRating() { }
	
	public ChallengeRating(Integer ordinal, String value, Integer experiencePoints) {
		super();
		this.ordinal = ordinal;
		this.value = value;
		this.experiencePoints = experiencePoints;
	}

	public Integer getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(Integer ordinal) {
		this.ordinal = ordinal;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getExperiencePoints() {
		return experiencePoints;
	}

	public void setExperiencePoints(Integer experiencePoints) {
		this.experiencePoints = experiencePoints;
	}
}
