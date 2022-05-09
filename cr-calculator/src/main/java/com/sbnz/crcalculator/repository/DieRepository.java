package com.sbnz.crcalculator.repository;

import java.util.Collection;

import com.sbnz.crcalculator.facts.Die;

public interface DieRepository {
	public Collection<Die> findAll();
}
