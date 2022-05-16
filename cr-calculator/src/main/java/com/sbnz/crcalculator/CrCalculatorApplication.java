package com.sbnz.crcalculator;

import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrCalculatorApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(CrCalculatorApplication.class, args);
	}

	@Bean
	public KieContainer kieContainer() {
		KieServices ks = KieServices.Factory.get();
		
		KieContainer kContainer = ks
				.newKieContainer(ks.newReleaseId("com.sbnz", "cr-calculator-kjar", "0.0.1-SNAPSHOT"));
		KieScanner kScanner = ks.newKieScanner(kContainer);
		kScanner.start(10_000);
				
		return kContainer;
	}
}
