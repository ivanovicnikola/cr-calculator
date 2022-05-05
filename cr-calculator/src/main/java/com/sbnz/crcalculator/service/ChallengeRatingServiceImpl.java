package com.sbnz.crcalculator.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.crcalculator.repository.ChallengeRatingRepository;

@Service
public class ChallengeRatingServiceImpl implements ChallengeRatingService {

	@Autowired
	private ChallengeRatingRepository challengeRatingRepository;
	
	@Override
	public String findByStep(String currentValue, Integer step) {
		return challengeRatingRepository.findByStep(currentValue, step);
	}

	@Override
	public Collection<String> findAll() {
		return challengeRatingRepository.findAll();
	}

	@Override
	public String findAverageChallengeRating(String firstValue, String secondValue) {
		return challengeRatingRepository.findAverageChallengeRating(firstValue, secondValue);
	}

}
