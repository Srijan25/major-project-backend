package com.learn.portal.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeptDto {

	private int deptId;
	private String deptName;
	private List<TeacherDto> teachers;
	private List<StudentDto> students;
	private HodDto hod;
}
