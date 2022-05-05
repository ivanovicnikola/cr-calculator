package com.sbnz.crcalculator.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ChallengeRatingInMemoryRepository implements ChallengeRatingRepository {

	List<String> challengeRatings = new ArrayList<String>();
	
	public ChallengeRatingInMemoryRepository() {
		challengeRatings.add("0");
		challengeRatings.add("1/8");
		challengeRatings.add("1/4");
		challengeRatings.add("1/2");
		challengeRatings.add("1");
		challengeRatings.add("2");
		challengeRatings.add("3");
		challengeRatings.add("4");
		challengeRatings.add("5");
		challengeRatings.add("6");
		challengeRatings.add("7");
		challengeRatings.add("8");
		challengeRatings.add("9");
		challengeRatings.add("10");
		challengeRatings.add("11");
		challengeRatings.add("12");
		challengeRatings.add("13");
		challengeRatings.add("14");
		challengeRatings.add("15");
		challengeRatings.add("16");
		challengeRatings.add("17");
		challengeRatings.add("18");
		challengeRatings.add("19");
		challengeRatings.add("20");
		challengeRatings.add("21");
		challengeRatings.add("22");
		challengeRatings.add("23");
		challengeRatings.add("24");
		challengeRatings.add("25");
		challengeRatings.add("26");
		challengeRatings.add("27");
		challengeRatings.add("28");
		challengeRatings.add("29");
		challengeRatings.add("30");
	}
	
	@Override
	public String findByStep(String currentValue, Integer step) {
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
	public Collection<String> findAll() {
		return challengeRatings;
	}

	@Override
	public String findAverageChallengeRating(String firstValue, String secondValue) {
		Integer firstIndex = challengeRatings.indexOf(firstValue);
		Integer secondIndex = challengeRatings.indexOf(secondValue);
		Integer averageIndex = (firstIndex + secondIndex)/2;
		return challengeRatings.get(averageIndex);
	}

}
