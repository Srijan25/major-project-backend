package com.learn.portal.service.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

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
	public UnitDto createUnit(UnitDto unitDto) {
		Unit unit = this.modelMapper.map(unitDto, Unit.class);
		Subject subject = this.subjectRepository.findById(subjectRepository.findAll().get(0).getSubjectId()).get();
		unit.setSubject(subject);
		this.unitRepository.save(unit);
		return unitDto;
	}

}
