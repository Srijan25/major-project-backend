package com.learn.portal.service;

import java.util.List;

import com.learn.portal.dto.UnitDto;

public interface UnitService {

	UnitDto createUnit(UnitDto unitDto);
	
	List<UnitDto> viewAllUnits();
	
	List<UnitDto> viewUnitsBySubject(int subjectId);
}
