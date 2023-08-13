package com.learn.portal.controllers;

import com.learn.portal.dto.DeptDto;
import com.learn.portal.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
