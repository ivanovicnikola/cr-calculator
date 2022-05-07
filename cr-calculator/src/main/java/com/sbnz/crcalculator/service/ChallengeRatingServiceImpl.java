package com.sbnz.crcalculator.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.crcalculator.facts.ChallengeRating;
import com.sbnz.crcalculator.repository.ChallengeRatingRepository;

@Service
public class ChallengeRatingServiceImpl implements ChallengeRatingService {

	@Autowired
	private ChallengeRatingRepository challengeRatingRepository;

	@Override
	public ChallengeRating findByOrdinal(Integer ordinal) {
		return challengeRatingRepository.findByOrdinal(ordinal);
	}

	@Override
	public Collection<ChallengeRating> findAll() {
		return challengeRatingRepository.findAll();
	}

	@Override
	public ChallengeRating findByValue(String value) {
		return challengeRatingRepository.findByValue(value);
	}
}
