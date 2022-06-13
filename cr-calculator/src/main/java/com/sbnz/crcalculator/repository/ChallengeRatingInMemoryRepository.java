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
		challengeRatings.add(new ChallengeRating(0, "0", 0, 2, 13, 1, 6, 3, 0, 1, 13));
		challengeRatings.add(new ChallengeRating(1, "1/8", 25, 2, 13, 7, 35, 3, 2, 3, 13));
		challengeRatings.add(new ChallengeRating(2, "1/4", 50, 2, 13, 36, 49, 3, 4, 5, 13));
		challengeRatings.add(new ChallengeRating(3, "1/2", 100, 2, 13, 50, 70, 3, 6, 8, 13));
		challengeRatings.add(new ChallengeRating(4, "1", 200, 2, 13, 71, 85, 3, 9, 14, 13));
		challengeRatings.add(new ChallengeRating(5, "2", 450, 2, 13, 86, 100, 3, 15, 20, 13));
		challengeRatings.add(new ChallengeRating(6, "3", 700, 2, 13, 101, 115, 4, 21, 26, 13));
		challengeRatings.add(new ChallengeRating(7, "4", 1100, 2, 14, 116, 130, 5, 27, 32, 14));
		challengeRatings.add(new ChallengeRating(8, "5", 1800, 3, 15, 131, 145, 6, 33, 38, 15));
		challengeRatings.add(new ChallengeRating(9, "6", 2300, 3, 15, 146, 160, 6, 39, 44, 15));
		challengeRatings.add(new ChallengeRating(10, "7", 2900, 3, 15, 161, 175, 6, 45, 50, 15));
		challengeRatings.add(new ChallengeRating(11, "8", 3900, 3, 16, 176, 190, 7, 51, 56, 16));
		challengeRatings.add(new ChallengeRating(12, "9", 5000, 4, 16, 191, 205, 7, 57, 62, 16));
		challengeRatings.add(new ChallengeRating(13, "10", 5900, 4, 17, 206, 220, 7, 63, 68, 16));
		challengeRatings.add(new ChallengeRating(14, "11", 7200, 4, 17, 221, 235, 8, 69, 74, 17));
		challengeRatings.add(new ChallengeRating(15, "12", 8400, 4, 17, 236, 250, 8, 75, 80, 17));
		challengeRatings.add(new ChallengeRating(16, "13", 10000, 5, 18, 251, 265, 8, 81, 86, 18));
		challengeRatings.add(new ChallengeRating(17, "14", 11500, 5, 18, 266, 280, 8, 87, 92, 18));
		challengeRatings.add(new ChallengeRating(18, "15", 13000, 5, 18, 281, 295, 8, 93, 98, 18));
		challengeRatings.add(new ChallengeRating(19, "16", 15000, 5, 18, 296, 310, 9, 99, 104, 18));
		challengeRatings.add(new ChallengeRating(20, "17", 18000, 6, 19, 311, 325, 10, 105, 110, 19));
		challengeRatings.add(new ChallengeRating(21, "18", 20000, 6, 19, 326, 340, 10, 111, 116, 19));
		challengeRatings.add(new ChallengeRating(22, "19", 22000, 6, 19, 341, 355, 10, 117, 122, 19));
		challengeRatings.add(new ChallengeRating(23, "20", 25000, 6, 19, 356, 400, 10, 123, 140, 19));
		challengeRatings.add(new ChallengeRating(24, "21", 33000, 7, 19, 401, 445, 11, 141, 158, 20));
		challengeRatings.add(new ChallengeRating(25, "22", 41000, 7, 19, 446, 490, 11, 159, 176, 20));
		challengeRatings.add(new ChallengeRating(26, "23", 50000, 7, 19, 491, 535, 11, 177, 194, 20));
		challengeRatings.add(new ChallengeRating(27, "24", 62000, 7, 19, 536, 580, 12, 195, 212, 21));
		challengeRatings.add(new ChallengeRating(28, "25", 75000, 8, 19, 581, 625, 12, 213, 230, 21));
		challengeRatings.add(new ChallengeRating(29, "26", 90000, 8, 19, 626, 670, 12, 231, 248, 21));
		challengeRatings.add(new ChallengeRating(30, "27", 105000, 8, 19, 671, 715, 13, 249, 266, 22));
		challengeRatings.add(new ChallengeRating(31, "28", 120000, 8, 19, 716, 760, 13, 267, 284, 22));
		challengeRatings.add(new ChallengeRating(32, "29", 135000, 9, 19, 761, 805, 13, 285, 302, 22));
		challengeRatings.add(new ChallengeRating(33, "30", 155000, 9, 19, 806, 850, 14, 303, 320, 23));
	}

	@Override
	public Collection<ChallengeRating> findAll() {
		return challengeRatings;
	}

}
