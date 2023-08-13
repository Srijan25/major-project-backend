package com.learn.portal.service;

import com.learn.portal.dto.TeacherDto;

public interface TeacherService {
    TeacherDto createTeacher(TeacherDto teacherDto, Integer deptId, Integer userId);

    TeacherDto viewTeacherById(Integer teacherId);

    TeacherDto viewTeacher();
}
