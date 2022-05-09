package com.sbnz.crcalculator.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbnz.crcalculator.facts.ChallengeRating;

@Repository
public class ChallengeRatingInMemoryRepository implements ChallengeRatingRepository {

	List<ChallengeRating> challengeRatings = new ArrayList<ChallengeRating>();
	
	public ChallengeRatingInMemoryRepository() {
		challengeRatings.add(new ChallengeRating(0, "0", 0));
		challengeRatings.add(new ChallengeRating(1, "1/8", 25));
		challengeRatings.add(new ChallengeRating(2, "1/4", 50));
		challengeRatings.add(new ChallengeRating(3, "1/2", 100));
		challengeRatings.add(new ChallengeRating(4, "1", 200));
		challengeRatings.add(new ChallengeRating(5, "2", 450));
		challengeRatings.add(new ChallengeRating(6, "3", 700));
		challengeRatings.add(new ChallengeRating(7, "4", 1100));
		challengeRatings.add(new ChallengeRating(8, "5", 1800));
		challengeRatings.add(new ChallengeRating(9, "6", 2300));
		challengeRatings.add(new ChallengeRating(10, "7", 2900));
		challengeRatings.add(new ChallengeRating(11, "8", 3900));
		challengeRatings.add(new ChallengeRating(12, "9", 5000));
		challengeRatings.add(new ChallengeRating(13, "10", 5900));
		challengeRatings.add(new ChallengeRating(14, "11", 7200));
		challengeRatings.add(new ChallengeRating(15, "12", 8400));
		challengeRatings.add(new ChallengeRating(16, "13", 10000));
		challengeRatings.add(new ChallengeRating(17, "14", 11500));
		challengeRatings.add(new ChallengeRating(18, "15", 13000));
		challengeRatings.add(new ChallengeRating(19, "16", 15000));
		challengeRatings.add(new ChallengeRating(20, "17", 18000));
		challengeRatings.add(new ChallengeRating(21, "18", 20000));
		challengeRatings.add(new ChallengeRating(22, "19", 22000));
		challengeRatings.add(new ChallengeRating(23, "20", 25000));
		challengeRatings.add(new ChallengeRating(24, "21", 33000));
		challengeRatings.add(new ChallengeRating(25, "22", 41000));
		challengeRatings.add(new ChallengeRating(26, "23", 50000));
		challengeRatings.add(new ChallengeRating(27, "24", 62000));
		challengeRatings.add(new ChallengeRating(28, "25", 75000));
		challengeRatings.add(new ChallengeRating(29, "26", 90000));
		challengeRatings.add(new ChallengeRating(30, "27", 105000));
		challengeRatings.add(new ChallengeRating(31, "28", 120000));
		challengeRatings.add(new ChallengeRating(32, "29", 135000));
		challengeRatings.add(new ChallengeRating(33, "30", 155000));
	}

	@Override
	public Collection<ChallengeRating> findAll() {
		return challengeRatings;
	}

}
