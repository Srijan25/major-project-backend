package com.learn.portal.controllers;

import com.learn.portal.dto.TeacherDto;
import com.learn.portal.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/create")
    public TeacherDto createTeacher(@RequestBody TeacherDto teacherDto, Integer deptId, Integer userId){
        return this.teacherService.createTeacher(teacherDto, deptId, userId);
    }
}
