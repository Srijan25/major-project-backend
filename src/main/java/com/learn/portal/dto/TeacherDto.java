package com.learn.portal.dto;

import java.util.List;

import com.learn.portal.entites.Dept;
import com.learn.portal.entites.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherDto {

	private int teacherId;
	private String teacherName;
//	private Dept dept;
//	private User user;
//	private List<SubjectDto> subjects;
}
