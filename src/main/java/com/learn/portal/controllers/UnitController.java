package com.learn.portal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.portal.dto.UnitDto;
import com.learn.portal.service.UnitService;

@RestController
@RequestMapping("/api/unit")
public class UnitController {

	@Autowired
	private UnitService unitService;
	
	@PostMapping("/")
	public ResponseEntity<UnitDto> createUnit(@RequestBody UnitDto unitDto){
		UnitDto createdUnit = this.unitService.createUnit(unitDto);
		return new ResponseEntity<UnitDto>(createdUnit, HttpStatus.CREATED);	
	}
	
	@GetMapping("/allUnits")
	public ResponseEntity<List<UnitDto>> viewAllUnits(){
		List<UnitDto> unitDtos = this.unitService.viewAllUnits();
		return new ResponseEntity<List<UnitDto>>(unitDtos, HttpStatus.OK);
	}
	
	@GetMapping("/unitsBySubject/{subjectId}")
	public ResponseEntity<List<UnitDto>> viewUnitsBySubject(@PathVariable Integer subjectId){
		List<UnitDto> unitDtos = this.unitService.viewAllUnits();
		return new ResponseEntity<List<UnitDto>>(unitDtos, HttpStatus.OK);
	}
}
