package com.sbnz.crcalculator.service;

import java.util.Collection;

public interface ChallengeRatingService {
	public String findByStep(String currentValue, Integer step);
	public Collection<String> findAll();
	public String findAverageChallengeRating(String firstValue, String secondValue);
}
