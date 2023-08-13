package com.learn.portal.service;

import com.learn.portal.dto.DeptDto;

public interface DeptService {
    DeptDto createDept(DeptDto deptDto);

    DeptDto viewDeptById(Integer deptId);

    DeptDto viewDept();
}
