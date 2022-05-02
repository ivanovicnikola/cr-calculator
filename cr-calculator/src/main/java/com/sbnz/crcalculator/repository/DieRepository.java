package com.sbnz.crcalculator.repository;

import java.util.Collection;

import com.sbnz.crcalculator.facts.Die;

public interface DieRepository {
	public Die findByName(String name);
	public Collection<Die> findAll();
}
