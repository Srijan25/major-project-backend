package com.learn.portal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.portal.dto.TeacherDto;
import com.learn.portal.service.TeacherService;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/create/{deptId}/{userId}")
    public TeacherDto createTeacher(@RequestBody TeacherDto teacherDto,@PathVariable Integer deptId, @PathVariable Integer userId){
        return this.teacherService.createTeacher(teacherDto, deptId, userId);
    }
}
