package com.sbnz.crcalculator.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.crcalculator.facts.Die;
import com.sbnz.crcalculator.repository.DieRepository;

@Service
public class DieServiceImpl implements DieService{

	@Autowired
	private DieRepository dieRepository;
	
	@Override
	public Die findByName(String name) {
		return dieRepository.findByName(name);
	}

	@Override
	public Collection<Die> findAll() {
		return dieRepository.findAll();
	}

}
