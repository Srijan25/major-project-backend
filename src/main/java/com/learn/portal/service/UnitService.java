package com.learn.portal.service;

import java.util.List;

import com.learn.portal.dto.UnitDto;

public interface UnitService {

	UnitDto createUnit(UnitDto unitDto, Integer subjectId);
	UnitDto getUnitById(Integer unitId);
	UnitDto updateUnit(UnitDto unitDto, Integer unitId);
	
	List<UnitDto> viewAllUnits();
	
	List<UnitDto> viewUnitsBySubject(int subjectId);
}
