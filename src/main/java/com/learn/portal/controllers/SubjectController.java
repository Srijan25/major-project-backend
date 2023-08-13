package com.learn.portal.controllers;

import com.learn.portal.dto.SubjectDto;
import com.learn.portal.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject")

public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/create/{semesterId}/{deptId}")
    public SubjectDto createSubject(SubjectDto subjectDto, Integer semesterId, Integer deptId){
        return this.subjectService.createSubject(subjectDto, semesterId, deptId);
    }

    @GetMapping("/view")
    public List<SubjectDto> viewAllSubjects(){
        return this.subjectService.viewAllSubjects();
    }

    @GetMapping("/view/{semesterId}/{deptId}")
    public List<SubjectDto> viewSubjectsByDeptAndSem(@PathVariable Integer semesterId, @PathVariable Integer deptId){
        return this.subjectService.viewSubjectsByDeptAndSem(semesterId, deptId);
    }



}
