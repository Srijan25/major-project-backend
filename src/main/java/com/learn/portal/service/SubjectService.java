package com.learn.portal.service;

import java.util.List;

import com.learn.portal.dto.SubjectDto;

public interface SubjectService {

	SubjectDto createSubject(SubjectDto subjectDto, Integer semester, Integer deptId);
	
	List<SubjectDto> viewAllSubjects();
	
	List<SubjectDto> viewSubjectsByDeptAndSem(Integer semester, Integer deptId);
}
