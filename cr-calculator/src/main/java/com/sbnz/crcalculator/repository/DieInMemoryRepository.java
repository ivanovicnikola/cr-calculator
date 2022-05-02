package com.sbnz.crcalculator.repository;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.sbnz.crcalculator.facts.Die;

@Repository
public class DieInMemoryRepository implements DieRepository {

	HashMap<String, Die> dice = new HashMap<>();
	
	public DieInMemoryRepository() {
		dice.put("d4", new Die("d4", 2.5));
		dice.put("d6", new Die("d6", 3.5));
		dice.put("d8", new Die("d8", 4.5));
		dice.put("d10", new Die("d10", 5.5));
		dice.put("d12", new Die("d12", 6.5));
		dice.put("d20", new Die("d20", 10.5));
	}
	
	@Override
	public Die findByName(String name) {
		return dice.get(name);
	}

	@Override
	public Collection<Die> findAll() {
		return dice.values();
	}

}
