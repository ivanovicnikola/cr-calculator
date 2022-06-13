package com.sbnz.crcalculator;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sbnz.crcalculator.facts.Ability;
import com.sbnz.crcalculator.facts.AbilityName;
import com.sbnz.crcalculator.facts.Action;
import com.sbnz.crcalculator.facts.Attack;
import com.sbnz.crcalculator.facts.AttackType;
import com.sbnz.crcalculator.facts.ChallengeRating;
import com.sbnz.crcalculator.facts.DamageUnit;
import com.sbnz.crcalculator.facts.Die;
import com.sbnz.crcalculator.facts.Monster;
import com.sbnz.crcalculator.facts.MonsterSize;
import com.sbnz.crcalculator.service.ChallengeRatingService;
import com.sbnz.crcalculator.service.DieService;
import com.sbnz.crcalculator.util.KieSessionUtils;


@SpringBootTest
class CrCalculatorApplicationTests {

	@Autowired
	private KieContainer kieContainer;
	
	@Autowired
	private DieService dieService;
	
	@Autowired
	private ChallengeRatingService challengeRatingService;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void basicCalculationTest() {
		Monster monster = getMonster();
		KieSession templateSession = KieSessionUtils.createTemplateSession();
		KieSession kieSession = kieContainer.newKieSession();
		templateSession.insert(monster);
		for(Die die: dieService.findAll()) {
			templateSession.insert(die);
		}
		int fired = templateSession.fireAllRules();
		templateSession.dispose();
		
		kieSession.insert(monster);
		for(ChallengeRating challengeRating: challengeRatingService.findAll()) {
			kieSession.insert(challengeRating);
		}
		fired += kieSession.fireAllRules();
		kieSession.dispose();
		
		assertEquals(fired, 14);
		assertEquals(monster.getChallengeRating().getValue(), "4");
		assertEquals(monster.isCalculated(), true);
	}
	
	@Test
	public void failedCalculationTest() {
		Monster monster = getMonster();
		monster.setActions(null);
		KieSession templateSession = KieSessionUtils.createTemplateSession();
		KieSession kieSession = kieContainer.newKieSession();
		templateSession.insert(monster);
		for(Die die: dieService.findAll()) {
			templateSession.insert(die);
		}
		int fired = templateSession.fireAllRules();
		templateSession.dispose();
		
		kieSession.insert(monster);
		for(ChallengeRating challengeRating: challengeRatingService.findAll()) {
			kieSession.insert(challengeRating);
		}
		fired += kieSession.fireAllRules();
		kieSession.dispose();
		
		assertEquals(fired, 7);
		assertEquals(monster.isCalculated(), false);
	}
	
	@Test
	public void forwardChainingTest() {
		Monster monster = getMonster();
		monster.setChallengeRating(new ChallengeRating(33, "30", 155000, 9, 19, 806, 850, 14, 303, 320, 23));
		KieSession templateSession = KieSessionUtils.createTemplateSession();
		KieSession kieSession = kieContainer.newKieSession();
		templateSession.insert(monster);
		for(Die die: dieService.findAll()) {
			templateSession.insert(die);
		}
		int fired = templateSession.fireAllRules();
		templateSession.dispose();
		
		kieSession.insert(monster);
		for(ChallengeRating challengeRating: challengeRatingService.findAll()) {
			kieSession.insert(challengeRating);
		}
		fired += kieSession.fireAllRules();
		kieSession.dispose();
		
		assertEquals(fired, 17);
		assertEquals(monster.getChallengeRating().getValue(), "4");
		assertEquals(monster.isCalculated(), true);
	}
	
	@Test
	public void attackRollDominantTest() {
		Monster monster = getMonster();
		
		List<Attack> attacks = new ArrayList<>();
		
		Attack attack1 = new Attack();
		attack1.setType(AttackType.ATTACK_ROLL);
		attack1.setNumberPerRound(2);
		attack1.setRelevantAbility(AbilityName.STRENGTH);
		attack1.setBaseDamage(new DamageUnit(3, new Die("d8", 4.5)));
		attacks.add(attack1);
		
		Attack attack2 = new Attack();
		attack2.setType(AttackType.SAVING_THROW);
		attack2.setNumberPerRound(1);
		attack2.setRelevantAbility(AbilityName.DEXTERITY);
		attack2.setBaseDamage(new DamageUnit(1, new Die("d4", 2.5)));
		attacks.add(attack2);
		
		monster.getActions().get(0).setAttacks(attacks);
		
		KieSession templateSession = KieSessionUtils.createTemplateSession();
		KieSession kieSession = kieContainer.newKieSession();
		templateSession.insert(monster);
		for(Die die: dieService.findAll()) {
			templateSession.insert(die);
		}
		int fired = templateSession.fireAllRules();
		templateSession.dispose();
		
		kieSession.insert(monster);
		for(ChallengeRating challengeRating: challengeRatingService.findAll()) {
			kieSession.insert(challengeRating);
		}
		fired += kieSession.fireAllRules();
		kieSession.dispose();
		
		assertEquals(fired, 17);
		assertEquals(monster.getChallengeRating().getValue(), "4");
		assertEquals(monster.isCalculated(), true);
	}
	
	@Test
	public void savingThrowDominantTest() {
		Monster monster = getMonster();
		
		List<Attack> attacks = new ArrayList<>();
		
		Attack attack1 = new Attack();
		attack1.setType(AttackType.SAVING_THROW);
		attack1.setNumberPerRound(2);
		attack1.setRelevantAbility(AbilityName.STRENGTH);
		attack1.setBaseDamage(new DamageUnit(3, new Die("d8", 4.5)));
		attacks.add(attack1);
		
		Attack attack2 = new Attack();
		attack2.setType(AttackType.ATTACK_ROLL);
		attack2.setNumberPerRound(1);
		attack2.setRelevantAbility(AbilityName.DEXTERITY);
		attack2.setBaseDamage(new DamageUnit(1, new Die("d4", 2.5)));
		attacks.add(attack2);
		
		monster.getActions().get(0).setAttacks(attacks);
		
		KieSession templateSession = KieSessionUtils.createTemplateSession();
		KieSession kieSession = kieContainer.newKieSession();
		templateSession.insert(monster);
		for(Die die: dieService.findAll()) {
			templateSession.insert(die);
		}
		int fired = templateSession.fireAllRules();
		templateSession.dispose();
		
		kieSession.insert(monster);
		for(ChallengeRating challengeRating: challengeRatingService.findAll()) {
			kieSession.insert(challengeRating);
		}
		fired += kieSession.fireAllRules();
		kieSession.dispose();
		
		assertEquals(fired, 17);
		assertEquals(monster.getChallengeRating().getValue(), "4");
		assertEquals(monster.isCalculated(), true);
	}
	
	private Monster getMonster() {
		Monster monster = new Monster();
		monster.setSize(MonsterSize.HUGE);
		monster.setArmorClass(13);
		monster.setNumberOfHitDice(10);
		monster.setStrength(new Ability(21, null));
		monster.setDexterity(new Ability(8, null));
		monster.setConstitution(new Ability(19, null));
		monster.setIntelligence(new Ability(5, null));
		monster.setWisdom(new Ability(9, null));
		monster.setCharisma(new Ability(6, null));
		monster.setChallengeRating(new ChallengeRating(8, "5", 1800, 3, 15, 131, 145, 6, 33, 38, 15));
		
		List<Action> actions = new ArrayList<>();
		
		Action action1 = new Action();
		Attack attack1 = new Attack();
		attack1.setType(AttackType.ATTACK_ROLL);
		attack1.setNumberPerRound(2);
		attack1.setRelevantAbility(AbilityName.STRENGTH);
		attack1.setBaseDamage(new DamageUnit(3, new Die("d8", 4.5)));
		action1.getAttacks().add(attack1);
		
		Action action2 = new Action();
		Attack attack2 = new Attack();
		attack2.setType(AttackType.ATTACK_ROLL);
		attack2.setNumberPerRound(1);
		attack2.setRelevantAbility(AbilityName.STRENGTH);
		attack2.setBaseDamage(new DamageUnit(3, new Die("d10", 5.5)));
		action2.getAttacks().add(attack2);
		
		actions.add(action1);
		actions.add(action2);
		monster.setActions(actions);
		
		return monster;
	}

}
