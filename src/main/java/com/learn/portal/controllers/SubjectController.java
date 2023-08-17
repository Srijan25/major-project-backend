package com.learn.portal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.portal.dto.SubjectDto;
import com.learn.portal.service.SubjectService;

@RestController
@RequestMapping("/api/subject")

public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/create/{semesterId}/{deptId}/{userId}")
    public SubjectDto createSubject(@RequestBody SubjectDto subjectDto,@PathVariable Integer semesterId, @PathVariable Integer deptId, @PathVariable Integer userId){
        return this.subjectService.createSubject(subjectDto, semesterId, deptId, userId);
    }

    @GetMapping("/view")
    public List<SubjectDto> viewAllSubjects(){
        return this.subjectService.viewAllSubjects();
    }

    @GetMapping("/view/{semesterId}/{deptId}")
    public List<SubjectDto> viewSubjectsByDeptAndSem(@PathVariable Integer semesterId, @PathVariable Integer deptId){
        return this.subjectService.viewSubjectsByDeptAndSem(semesterId, deptId);
    }

    @GetMapping("/viewByTeacher/{userId}")
    public List<SubjectDto> viewSubjectsByTeacher (@PathVariable Integer userId){
    	return this.subjectService.viewSubjectsByTeacher(userId);
    }


}
