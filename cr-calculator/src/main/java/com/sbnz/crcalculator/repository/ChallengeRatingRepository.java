package com.sbnz.crcalculator.repository;

import java.util.Collection;

public interface ChallengeRatingRepository {
	public Double findByStep(Double currentValue, Integer step);
	public Collection<Double> findAll();
	public Double findAverageChallengeRating(Double firstValue, Double secondValue);
}
