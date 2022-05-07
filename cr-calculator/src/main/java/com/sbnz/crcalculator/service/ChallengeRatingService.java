package com.sbnz.crcalculator.service;

import java.util.Collection;

import com.sbnz.crcalculator.facts.ChallengeRating;

public interface ChallengeRatingService {
	public ChallengeRating findByOrdinal(Integer ordinal);
	public Collection<ChallengeRating> findAll();
	public ChallengeRating findByValue(String value);
}
