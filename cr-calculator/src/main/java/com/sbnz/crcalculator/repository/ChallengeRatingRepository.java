package com.sbnz.crcalculator.repository;

import java.util.Collection;

import com.sbnz.crcalculator.facts.ChallengeRating;

public interface ChallengeRatingRepository {
	public Collection<ChallengeRating> findAll();
}
