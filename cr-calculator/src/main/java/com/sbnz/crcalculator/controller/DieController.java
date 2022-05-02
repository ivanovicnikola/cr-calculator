package com.sbnz.crcalculator.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.crcalculator.facts.Die;
import com.sbnz.crcalculator.service.DieService;

@RestController
@RequestMapping("/dice")
public class DieController {

	@Autowired
	private DieService dieService;
	
	@GetMapping()
	public ResponseEntity<Collection<Die>> findAll() {
		return new ResponseEntity<>(dieService.findAll(), HttpStatus.OK);
	}
}
