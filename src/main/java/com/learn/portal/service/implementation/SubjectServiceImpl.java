package com.learn.portal.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.learn.portal.dto.SubjectDto;
import com.learn.portal.entites.Dept;
import com.learn.portal.entites.Subject;
import com.learn.portal.repository.DeptRepository;
import com.learn.portal.repository.SubjectRepository;
import com.learn.portal.service.SubjectService;
import org.springframework.stereotype.Service;

@Service

public class SubjectServiceImpl implements SubjectService{

	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private DeptRepository deptRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public SubjectDto createSubject(SubjectDto subjectDto, Integer semester, Integer deptId) {
		Subject subject= this.modelMapper.map(subjectDto, Subject.class);
		subject.setSemester(semester);
		subject.setDept(this.deptRepository.findById(deptId).get());
		Subject savedSubject = this.subjectRepository.save(subject);
		return this.modelMapper.map(savedSubject, SubjectDto.class);
	}

	@Override
	public List<SubjectDto> viewAllSubjects() {
		List<Subject> subjects= this.subjectRepository.findAll();
		List<SubjectDto> subjectDtos = subjects.stream()
				.map((subject)->this.modelMapper.map(subject, SubjectDto.class))
				.collect(Collectors.toList());
		return subjectDtos;
	}

	@Override
	public List<SubjectDto> viewSubjectsByDeptAndSem(Integer semester, Integer deptId) {
		Dept dept = this.deptRepository.findById(deptId).orElseThrow();
		List<Subject> subjects = this.subjectRepository.findByDeptAndSemester(dept, semester);
		List<SubjectDto> subjectDtos = subjects.stream()
				.map((subject)->this.modelMapper.map(subject, SubjectDto.class))
				.collect(Collectors.toList());
		return subjectDtos;
	}
	
	

}
