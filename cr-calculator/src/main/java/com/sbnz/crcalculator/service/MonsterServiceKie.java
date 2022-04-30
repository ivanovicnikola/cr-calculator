package com.sbnz.crcalculator.service;

import java.io.InputStream;
import java.util.List;

import org.drools.template.DataProvider;
import org.drools.template.DataProviderCompiler;
import org.drools.template.objects.ArrayDataProvider;
import org.kie.api.KieBase;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.crcalculator.facts.Monster;

@Service
public class MonsterServiceKie implements MonsterService {
	
	//@Autowired
	//private KieContainer kieContainer;
	
	@Override
	public Monster getClassifiedMonster(Monster monster) {
		String drl = getAbilityModifierRules();
		KieSession ksession = createKieSessionFromDRL(drl);
		ksession.insert(monster.getStrength());
		ksession.insert(monster.getDexterity());
		ksession.insert(monster.getConstitution());
		ksession.insert(monster.getIntelligence());
		ksession.insert(monster.getWisdom());
		ksession.insert(monster.getCharisma());
		ksession.fireAllRules();
		ksession.dispose();
		/*KieSession kieSession = kieContainer.newKieSession("ExampleSession");
        kieSession.insert(monster);
        kieSession.fireAllRules();
        kieSession.dispose();*/
		return monster;
	}
	
	private String getAbilityModifierRules() {
		InputStream template = MonsterServiceKie.class.getResourceAsStream("/templates/ability-modifiers.drt");
		
		DataProvider dataProvider = new ArrayDataProvider(new String[][] {
			new String[] {"0", "1", "-5"},
			new String[] {"2", "3", "-4"},
			new String[] {"4", "5", "-3"},
			new String[] {"6", "7", "-2"},
			new String[] {"8", "9", "-1"},
			new String[] {"10", "11", "0"},
			new String[] {"12", "13", "1"},
			new String[] {"14", "15", "2"},
			new String[] {"16", "17", "3"},
			new String[] {"18", "19", "4"},
			new String[] {"20", "21", "5"},
			new String[] {"22", "23", "6"},
			new String[] {"24", "25", "7"},
			new String[] {"26", "27", "8"},
			new String[] {"29", "30", "9"},
			new String[] {"30", "31", "10"},
		});
		
		DataProviderCompiler converter = new DataProviderCompiler();
		String drl = converter.compile(dataProvider, template);
		System.out.println(drl);
		return drl;
	}

	private KieSession createKieSessionFromDRL(String drl){
        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(drl, ResourceType.DRL);
        
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
}
