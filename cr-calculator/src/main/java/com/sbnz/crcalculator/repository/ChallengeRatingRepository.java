package com.sbnz.crcalculator.repository;

import java.util.Collection;

public interface ChallengeRatingRepository {
	public String findByStep(String currentValue, Integer step);
	public Collection<String> findAll();
	public String findAverageChallengeRating(String firstValue, String secondValue);
}
