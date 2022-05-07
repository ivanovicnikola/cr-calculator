package com.sbnz.crcalculator.repository;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.sbnz.crcalculator.facts.ChallengeRating;

@Repository
public class ChallengeRatingInMemoryRepository implements ChallengeRatingRepository {

	HashMap<Integer, ChallengeRating> challengeRatings = new HashMap<Integer, ChallengeRating>();
	
	public ChallengeRatingInMemoryRepository() {
		challengeRatings.put(0, new ChallengeRating(0, "0", 0));
		challengeRatings.put(1, new ChallengeRating(1, "1/8", 25));
		challengeRatings.put(2, new ChallengeRating(2, "1/4", 50));
		challengeRatings.put(3, new ChallengeRating(3, "1/2", 100));
		challengeRatings.put(4, new ChallengeRating(4, "1", 200));
		challengeRatings.put(5, new ChallengeRating(5, "2", 450));
		challengeRatings.put(6, new ChallengeRating(6, "3", 700));
		challengeRatings.put(7, new ChallengeRating(7, "4", 1100));
		challengeRatings.put(8, new ChallengeRating(8, "5", 1800));
		challengeRatings.put(9, new ChallengeRating(9, "6", 2300));
		challengeRatings.put(10, new ChallengeRating(10, "7", 2900));
		challengeRatings.put(11, new ChallengeRating(11, "8", 3900));
		challengeRatings.put(12, new ChallengeRating(12, "9", 5000));
		challengeRatings.put(13, new ChallengeRating(13, "10", 5900));
		challengeRatings.put(14, new ChallengeRating(14, "11", 7200));
		challengeRatings.put(15, new ChallengeRating(15, "12", 8400));
		challengeRatings.put(16, new ChallengeRating(16, "13", 10000));
		challengeRatings.put(17, new ChallengeRating(17, "14", 11500));
		challengeRatings.put(18, new ChallengeRating(18, "15", 13000));
		challengeRatings.put(19, new ChallengeRating(19, "16", 15000));
		challengeRatings.put(20, new ChallengeRating(20, "17", 18000));
		challengeRatings.put(21, new ChallengeRating(21, "18", 20000));
		challengeRatings.put(22, new ChallengeRating(22, "19", 22000));
		challengeRatings.put(23, new ChallengeRating(23, "20", 25000));
		challengeRatings.put(24, new ChallengeRating(24, "21", 33000));
		challengeRatings.put(25, new ChallengeRating(25, "22", 41000));
		challengeRatings.put(26, new ChallengeRating(26, "23", 50000));
		challengeRatings.put(27, new ChallengeRating(27, "24", 62000));
		challengeRatings.put(28, new ChallengeRating(28, "25", 75000));
		challengeRatings.put(29, new ChallengeRating(29, "26", 90000));
		challengeRatings.put(30, new ChallengeRating(30, "27", 105000));
		challengeRatings.put(31, new ChallengeRating(31, "28", 120000));
		challengeRatings.put(32, new ChallengeRating(32, "29", 135000));
		challengeRatings.put(33, new ChallengeRating(33, "30", 155000));
	}

	@Override
	public ChallengeRating findByOrdinal(Integer ordinal) {
		if(ordinal < 0) {
			return challengeRatings.get(0);
		}
		if(ordinal > 33) {
			return challengeRatings.get(33);
		}
		return challengeRatings.get(ordinal);
	}

	@Override
	public Collection<ChallengeRating> findAll() {
		return challengeRatings.values();
	}

	@Override
	public ChallengeRating findByValue(String value) {
		for(ChallengeRating challengeRating : challengeRatings.values()) {
			if (challengeRating.getValue().equals(value)) {
				return challengeRating;
			}
		}
		return null;
	}

}
