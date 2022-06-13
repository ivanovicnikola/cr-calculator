package com.sbnz.crcalculator.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.crcalculator.facts.ChallengeRating;
import com.sbnz.crcalculator.facts.Die;
import com.sbnz.crcalculator.facts.Monster;
import com.sbnz.crcalculator.util.KieSessionUtils;

@Service
public class MonsterServiceKie implements MonsterService {
	
	@Autowired
	private KieContainer kieContainer;
	
	@Autowired
	private DieService dieService;
	
	@Autowired
	private ChallengeRatingService challengeRatingService;
	
	@Override
	public Monster getClassifiedMonster(Monster monster) {
		KieSession templateSession = KieSessionUtils.createTemplateSession();
		KieSession kieSession = kieContainer.newKieSession();
		templateSession.insert(monster);
		for(Die die: dieService.findAll()) {
			templateSession.insert(die);
		}
		templateSession.fireAllRules();
		templateSession.dispose();
		
		kieSession.insert(monster);
		for(ChallengeRating challengeRating: challengeRatingService.findAll()) {
			kieSession.insert(challengeRating);
		}
		kieSession.fireAllRules();
		kieSession.dispose();
		return monster;
	}
}
