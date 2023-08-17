package com.learn.portal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.portal.dto.StudentDto;
import com.learn.portal.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/create/{deptId}/{userId}")
    public StudentDto createStudent(@RequestBody StudentDto studentDto, @PathVariable Integer deptId, @PathVariable Integer userId){
        return this.studentService.createStudent(studentDto, deptId, userId);
    }

}
