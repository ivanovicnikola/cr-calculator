package com.sbnz.crcalculator.service;

import java.util.Collection;

public interface ChallengeRatingService {
	public Double findByStep(Double currentValue, Integer step);
	public Collection<Double> findAll();
	public Double findAverageChallengeRating(Double firstValue, Double secondValue);
}
