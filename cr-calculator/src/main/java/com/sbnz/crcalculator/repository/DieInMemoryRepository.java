package com.sbnz.crcalculator.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbnz.crcalculator.facts.Die;

@Repository
public class DieInMemoryRepository implements DieRepository {

	List<Die> dice = new ArrayList<>();
	
	public DieInMemoryRepository() {
		dice.add(new Die("d4", 2.5));
		dice.add(new Die("d6", 3.5));
		dice.add(new Die("d8", 4.5));
		dice.add(new Die("d10", 5.5));
		dice.add(new Die("d12", 6.5));
		dice.add(new Die("d20", 10.5));
	}

	@Override
	public Collection<Die> findAll() {
		return dice;
	}

}
