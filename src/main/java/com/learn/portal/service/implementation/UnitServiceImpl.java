package com.learn.portal.service.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.learn.portal.dto.UnitDto;
import com.learn.portal.entites.Subject;
import com.learn.portal.entites.Unit;
import com.learn.portal.repository.SubjectRepository;
import com.learn.portal.repository.UnitRepository;
import com.learn.portal.service.UnitService;

public class UnitServiceImpl implements UnitService {

	@Autowired
	private UnitRepository unitRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UnitDto createUnit(UnitDto unitDto) {
		Unit unit = this.modelMapper.map(unitDto, Unit.class);
		Subject subject=this.subjectRepository.findById(unit.getSubject().getSubjectId()).orElseThrow();
		unit.setSubject(subject);
		Unit addedUnit = this.unitRepository.save(unit);
		return this.modelMapper.map(addedUnit, UnitDto.class);
	}

}
