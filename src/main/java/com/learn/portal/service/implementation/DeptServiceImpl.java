package com.learn.portal.service.implementation;

import com.learn.portal.dto.DeptDto;
import com.learn.portal.entites.Dept;
import com.learn.portal.repository.DeptRepository;
import com.learn.portal.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptRepository deptRepository;
    @Override
    public DeptDto createDept(DeptDto deptDto) {
        Dept dept = new Dept();
        dept.setDeptName(deptDto.getDeptName());
        deptRepository.save(dept);
        return deptDto;

    }

    @Override
    public DeptDto viewDeptById(Integer deptId) {
        Dept dept = this.deptRepository.findById(deptId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid dept Id:" + deptId));
        DeptDto deptDto = new DeptDto();
        deptDto.setDeptName(dept.getDeptName());
        return deptDto;
    }

    @Override
    public DeptDto viewDept() {
        Dept dept = deptRepository.findAll().get(0);
        DeptDto deptDto = new DeptDto();
        deptDto.setDeptName(dept.getDeptName());
        return deptDto;
    }
}
