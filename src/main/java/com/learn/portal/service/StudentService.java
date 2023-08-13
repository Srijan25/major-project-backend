package com.learn.portal.service;

import com.learn.portal.dto.StudentDto;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto, Integer deptId, Integer userId);

    StudentDto viewStudentById(Integer studentId);

    StudentDto viewStudent();
}
