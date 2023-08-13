package com.learn.portal.dto;

import java.util.List;

import com.learn.portal.entites.Dept;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectDto {

	private int subjectId;
	private String subjectName;
	private String subjectCode;
	private List<UnitDto> units;
	private Integer semester;
//	private DeptDto dept;
//	private TeacherDto teacher;
}
