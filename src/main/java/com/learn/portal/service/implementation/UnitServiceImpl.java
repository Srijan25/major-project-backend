package com.learn.portal.service.implementation;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.portal.dto.UnitDto;
import com.learn.portal.entites.Subject;
import com.learn.portal.entites.Unit;
import com.learn.portal.repository.SubjectRepository;
import com.learn.portal.repository.UnitRepository;
import com.learn.portal.service.UnitService;
import org.springframework.stereotype.Service;

@Service
public class UnitServiceImpl implements UnitService {

	@Autowired
	private UnitRepository unitRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UnitDto createUnit(UnitDto unitDto, Integer subjectId) {
		Unit unit = this.modelMapper.map(unitDto, Unit.class);
		Subject subject = this.subjectRepository.findById(subjectId).orElseThrow();
		unit.setSubject(subject);
		Unit savedUnit = this.unitRepository.save(unit);
		return this.modelMapper.map(savedUnit, UnitDto.class);
	}
	

	@Override
	public List<UnitDto> viewAllUnits() {
		List<Unit> units = this.unitRepository.findAll();
		List<UnitDto> unitDtos = units.stream()
				.map((unit)->this.modelMapper.map(unit, UnitDto.class))
				.collect(Collectors.toList());
		return unitDtos;
	}

	@Override
	public List<UnitDto> viewUnitsBySubject(int subjectId) {
		Subject subject = this.subjectRepository.findById(subjectId).orElseThrow();
		List<Unit> units = this.unitRepository.findBySubject(subject);
		List<UnitDto> unitDtos = units.stream()
				.map((unit)->this.modelMapper.map(unit, UnitDto.class))
				.sorted(Comparator.comparing(UnitDto::getUnitNumber))
				.collect(Collectors.toList());
		return unitDtos;
	}


	@Override
	public UnitDto getUnitById(Integer unitId) {
		Unit unit = this.unitRepository.findById(unitId).orElseThrow();
		return this.modelMapper.map(unit, UnitDto.class);
	}


	@Override
	public UnitDto updateUnit(UnitDto unitDto, Integer unitId) {
		Unit unit = this.unitRepository.findById(unitId).orElseThrow();
		
		unit.setNotes(unitDto.getNotes());
		
		Unit savedUnit = this.unitRepository.save(unit);
		return this.modelMapper.map(savedUnit, UnitDto.class);
	}

}
