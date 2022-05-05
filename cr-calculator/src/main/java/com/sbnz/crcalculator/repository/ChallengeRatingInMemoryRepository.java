package com.sbnz.crcalculator.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ChallengeRatingInMemoryRepository implements ChallengeRatingRepository {

	List<Double> challengeRatings = new ArrayList<Double>();
	
	public ChallengeRatingInMemoryRepository() {
		challengeRatings.add(0.0);
		challengeRatings.add(0.125);
		challengeRatings.add(0.25);
		challengeRatings.add(0.5);
		for(double i = 1; i <= 30; i++) {
			challengeRatings.add(i);
		}
	}
	
	@Override
	public Double findByStep(Double currentValue, Integer step) {
		Integer index = challengeRatings.indexOf(currentValue) + step;
		if(index < 0) {
			return challengeRatings.get(0);
		}
		if(index >= challengeRatings.size()) {
			return challengeRatings.get(challengeRatings.size() - 1);
		}
		return challengeRatings.get(index);
	}

	@Override
	public Collection<Double> findAll() {
		return challengeRatings;
	}

	@Override
	public Double findAverageChallengeRating(Double firstValue, Double secondValue) {
		Integer firstIndex = challengeRatings.indexOf(firstValue);
		Integer secondIndex = challengeRatings.indexOf(secondValue);
		Integer averageIndex = (firstIndex + secondIndex)/2;
		return challengeRatings.get(averageIndex);
	}

}
