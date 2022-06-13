package com.sbnz.crcalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.crcalculator.facts.Monster;
import com.sbnz.crcalculator.service.MonsterService;

@RestController
@RequestMapping("/monsters")
public class MonsterController {
	
	@Autowired
	private MonsterService monsterService;
	
	@PostMapping()
	public ResponseEntity<Monster> submitMonster(@RequestBody Monster monster) {
		monster = monsterService.getClassifiedMonster(monster);
		if(!monster.isCalculated())
			return new ResponseEntity<Monster>(monster, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Monster>(monster, HttpStatus.OK);
	}
}
