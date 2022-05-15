package com.sbnz.crcalculator.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import org.drools.decisiontable.ExternalSpreadsheetCompiler;
import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.ClassObjectFilter;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;

import com.sbnz.crcalculator.events.CalculationEvent;
import com.sbnz.crcalculator.events.CalculationEventSessionStorage;
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
	
	@Autowired
	private CalculationEventSessionStorage eventStorage;
	
	@Override
	public Monster getClassifiedMonster(Monster monster) {
		monster.setExpectedChallengeRating(monster.getChallengeRating());
		KieSession kieSession = createKieSession();
		//KieBase kieBase = kieContainer.getKieBase("ExampleKBase");
		//KieSession kieSession = kieBase.newKieSession();
		kieSession.insert(monster);
		for(Die die: dieService.findAll()) {
			kieSession.insert(die);
		}
		for(ChallengeRating challengeRating: challengeRatingService.findAll()) {
			kieSession.insert(challengeRating);
		}
		for(CalculationEvent event: eventStorage.getEvents()) {
			kieSession.insert(event);
		}
		kieSession.fireAllRules();
		kieSession.getAgenda().getAgendaGroup("recalculate").setFocus();
		kieSession.fireAllRules();
		kieSession.getAgenda().getAgendaGroup("messages").setFocus();
		kieSession.fireAllRules();
		kieSession.dispose();
		Collection<CalculationEvent> newEvents = (Collection<CalculationEvent>) kieSession.getObjects(new ClassObjectFilter(CalculationEvent.class));
		eventStorage.setEvents(newEvents);
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
