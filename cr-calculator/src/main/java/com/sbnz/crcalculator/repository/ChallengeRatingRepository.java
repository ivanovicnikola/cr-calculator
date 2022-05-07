package com.sbnz.crcalculator.repository;

import java.util.Collection;

import com.sbnz.crcalculator.facts.ChallengeRating;

public interface ChallengeRatingRepository {
	public ChallengeRating findByOrdinal(Integer ordinal);
	public Collection<ChallengeRating> findAll();
	public ChallengeRating findByValue(String value);
}
