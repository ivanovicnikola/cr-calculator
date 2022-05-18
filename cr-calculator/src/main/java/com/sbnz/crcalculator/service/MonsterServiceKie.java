package com.sbnz.crcalculator.service;

import java.io.InputStream;
import java.util.List;

import org.drools.decisiontable.ExternalSpreadsheetCompiler;
import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.crcalculator.facts.ChallengeRating;
import com.sbnz.crcalculator.facts.Die;
import com.sbnz.crcalculator.facts.Monster;

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
		KieSession templateSession = createTemplateSession();
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
	
	private String getAbilityModifierRules() {
		InputStream template = MonsterServiceKie.class.getResourceAsStream("/templates/ability-modifiers.drt");
		InputStream data = MonsterServiceKie.class.getResourceAsStream("/templates/ability-modifiers.xls");
		ExternalSpreadsheetCompiler converter = new ExternalSpreadsheetCompiler();
		String drl = converter.compile(data, template, 3, 2);
		return drl;
	}
	
	private String getHitDiceBySizeRules() {
		InputStream template = MonsterServiceKie.class.getResourceAsStream("/templates/hit-dice-by-size.drt");
		InputStream data = MonsterServiceKie.class.getResourceAsStream("/templates/hit-dice-by-size.xls");
		ExternalSpreadsheetCompiler converter = new ExternalSpreadsheetCompiler();
		String drl = converter.compile(data, template, 3, 2);
		return drl;
	}
	
	private KieSession createTemplateSession() {
		KieHelper kieHelper = new KieHelper();
		
		String modifiers = getAbilityModifierRules();
		kieHelper.addContent(modifiers, ResourceType.DRL);
		
		String hitDiceBySize = getHitDiceBySizeRules();
		kieHelper.addContent(hitDiceBySize, ResourceType.DRL);
        
        Results results = kieHelper.verify();
        
        if (results.hasMessages(Message.Level.WARNING, Message.Level.ERROR)){
            List<Message> messages = results.getMessages(Message.Level.WARNING, Message.Level.ERROR);
            for (Message message : messages) {
                System.out.println("Error: "+message.getText());
            }
            
            throw new IllegalStateException("Compilation errors were found. Check the logs.");
        }
        
        KieServices ks = KieServices.Factory.get();
        KieBaseConfiguration kbconf = ks.newKieBaseConfiguration();
        kbconf.setOption(EventProcessingOption.STREAM);
        
        KieBase kieBase = kieHelper.build(kbconf);
        
        return kieBase.newKieSession();
	}
}
