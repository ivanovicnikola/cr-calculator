package com.sbnz.crcalculator.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.crcalculator.facts.ChallengeRating;
import com.sbnz.crcalculator.service.ChallengeRatingService;

@RestController
@RequestMapping("/challengeRatings")
public class ChallengeRatingController {

	@Autowired
	private ChallengeRatingService challengeRatingService;
	
	@GetMapping()
	public ResponseEntity<Collection<ChallengeRating>> findAll() {
		return new ResponseEntity<>(challengeRatingService.findAll(), HttpStatus.OK);
	}
}
