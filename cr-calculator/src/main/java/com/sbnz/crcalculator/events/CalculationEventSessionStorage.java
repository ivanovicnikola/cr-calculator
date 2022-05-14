package com.sbnz.crcalculator.events;

import java.util.ArrayList;
import java.util.List;

public class CalculationEventSessionStorage {
	
	private List<CalculationEvent> events = new ArrayList<>();
	
	public CalculationEventSessionStorage() { }

	public CalculationEventSessionStorage(List<CalculationEvent> events) {
		super();
		this.events = events;
	}

	public List<CalculationEvent> getEvents() {
		return events;
	}

	public void setEvents(List<CalculationEvent> events) {
		this.events = events;
	}

}
