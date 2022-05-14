package com.sbnz.crcalculator.events;

import java.util.Date;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import com.sbnz.crcalculator.facts.Monster;

@Role(Role.Type.EVENT)
@Timestamp("executionTime")
@Expires("2h30m")
public class CalculationEvent {

	private Date executionTime;
	private Monster monster;
	
	public CalculationEvent() {
		super();
	}

	public CalculationEvent(Monster monster) {
		super();
		this.monster = monster;
		this.executionTime = new Date();
	}

	public Date getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(Date executionTime) {
		this.executionTime = executionTime;
	}

	public Monster getMonster() {
		return monster;
	}

	public void setMonster(Monster monster) {
		this.monster = monster;
	}
	
}
