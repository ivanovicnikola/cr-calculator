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
	public Collection<ChallengeRating> findAll() {
		return challengeRatingRepository.findAll();
	}

}
