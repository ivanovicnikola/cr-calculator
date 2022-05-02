package com.sbnz.crcalculator.service;

import java.util.Collection;

import com.sbnz.crcalculator.facts.Die;

public interface DieService {
	public Die findByName(String name);
	public Collection<Die> findAll();
}
