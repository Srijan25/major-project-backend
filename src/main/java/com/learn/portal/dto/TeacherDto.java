package com.learn.portal.dto;

import java.util.List;

import com.learn.portal.entites.Dept;
import com.learn.portal.entites.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherDto {


	private String teacherName;
	private Integer deptId;
	private Integer userId;
}
