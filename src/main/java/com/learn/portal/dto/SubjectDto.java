package com.learn.portal.dto;

import java.util.List;

import com.learn.portal.entites.Unit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectDto {

	private int subjectId;
	private String subjectName;
	private String subjectCode;
	private List<Unit> units;
	private TeacherDto teacher;
}
