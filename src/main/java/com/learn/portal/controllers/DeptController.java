package com.learn.portal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.portal.dto.DeptDto;
import com.learn.portal.service.DeptService;

@RestController
@RequestMapping("/api/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @PostMapping("/create")
    public DeptDto createDept(@RequestBody DeptDto deptDto){
        return this.deptService.createDept(deptDto);
    }

    @GetMapping("/view/{deptId}")
    public DeptDto viewDeptById(@PathVariable Integer deptId){
        return this.deptService.viewDeptById(deptId);
    }

    @GetMapping("/view")
    public DeptDto viewDept(){
        return this.deptService.viewDept();
    }
}
