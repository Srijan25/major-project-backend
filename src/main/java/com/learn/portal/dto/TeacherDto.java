package com.learn.portal.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherDto {

	private int teacherId;
	private String teacherName;
	private DeptDto dept;
	private UserDto user;
	private List<SubjectDto> subjects;
}
