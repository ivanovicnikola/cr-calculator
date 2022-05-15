package com.sbnz.crcalculator.events;

import java.util.ArrayList;
import java.util.Collection;

public class CalculationEventSessionStorage {
	
	private Collection<CalculationEvent> events = new ArrayList<>();
	
	public CalculationEventSessionStorage() { }

	public CalculationEventSessionStorage(Collection<CalculationEvent> events) {
		super();
		this.events = events;
	}

	public Collection<CalculationEvent> getEvents() {
		return events;
	}

	public void setEvents(Collection<CalculationEvent> events) {
		this.events = events;
	}

}
