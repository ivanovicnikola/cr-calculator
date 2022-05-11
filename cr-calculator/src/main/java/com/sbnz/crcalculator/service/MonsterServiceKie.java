package com.sbnz.crcalculator.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.drools.decisiontable.ExternalSpreadsheetCompiler;
import org.kie.api.KieBase;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
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
		//KieSession kieSession = createKieSession();
		KieBase kieBase = kieContainer.getKieBase("ExampleKBase");
		KieSession kieSession = kieBase.newKieSession();
		kieSession.insert(monster);
		for(Die die: dieService.findAll()) {
			kieSession.insert(die);
		}
		for(ChallengeRating challengeRating: challengeRatingService.findAll()) {
			kieSession.insert(challengeRating);
		}
		kieSession.fireAllRules();
		kieSession.getAgenda().getAgendaGroup("recalculate").setFocus();
		kieSession.fireAllRules();
		kieSession.dispose();
		return monster;
	}
	
	private String getStatisticsByCrRules() {
		InputStream template = MonsterServiceKie.class.getResourceAsStream("/templates/statistics-by-cr.drl");
		InputStream data = MonsterServiceKie.class.getResourceAsStream("/templates/statistics-by-cr.xlsx");
		ExternalSpreadsheetCompiler converter = new ExternalSpreadsheetCompiler();
		String drl = converter.compile(data, template, 3, 2);
		return drl;
	}
	
	private String getAbilityModifierRules() {
		InputStream template = MonsterServiceKie.class.getResourceAsStream("/templates/ability-modifiers.drl");
		InputStream data = MonsterServiceKie.class.getResourceAsStream("/templates/ability-modifiers.xlsx");
		ExternalSpreadsheetCompiler converter = new ExternalSpreadsheetCompiler();
		String drl = converter.compile(data, template, 3, 2);
		return drl;
	}
	
	private String getHitDiceBySizeRules() {
		InputStream template = MonsterServiceKie.class.getResourceAsStream("/templates/hit-dice-by-size.drl");
		InputStream data = MonsterServiceKie.class.getResourceAsStream("/templates/hit-dice-by-size.xlsx");
		ExternalSpreadsheetCompiler converter = new ExternalSpreadsheetCompiler();
		String drl = converter.compile(data, template, 3, 2);
		return drl;
	}
	
	private KieSession createKieSession() {
		KieHelper kieHelper = new KieHelper();
		try {
			kieHelper = getResourceFolderFiles(kieHelper);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String modifiers = getAbilityModifierRules();
		kieHelper.addContent(modifiers, ResourceType.DRL);
		
		String statsByCr = getStatisticsByCrRules();
		kieHelper.addContent(statsByCr, ResourceType.DRL);
		
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
        
        return kieHelper.build().newKieSession();
	}
	
	private static KieHelper getResourceFolderFiles (KieHelper kieHelper) throws IOException {  
	    ClassLoader cl =  Thread.currentThread().getContextClassLoader().getClass().getClassLoader();
	    ResourcePatternResolver resolver = new
	    PathMatchingResourcePatternResolver(cl);     
	    Resource[] resources = resolver.getResources("/rules/**/*.drl") ;  
	    for (Resource resource: resources) {
	    	kieHelper.addResource(ResourceFactory.newFileResource(resource.getFile()), ResourceType.DRL);
	    }
	    return kieHelper;
	  }
}
