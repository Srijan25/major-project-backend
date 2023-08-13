package com.learn.portal.service.implementation;

import com.learn.portal.dto.DeptDto;
import com.learn.portal.dto.TeacherDto;
import com.learn.portal.dto.UserDto;
import com.learn.portal.entites.Dept;
import com.learn.portal.entites.Subject;
import com.learn.portal.entites.User;
import com.learn.portal.repository.DeptRepository;
import com.learn.portal.repository.TeacherRepository;
import com.learn.portal.repository.UserRepository;
import com.learn.portal.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;

public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DeptRepository deptRepository;
    @Override
    public TeacherDto createTeacher(TeacherDto teacherDto, Integer deptId, Integer userId) {
        TeacherDto teacherDto1 = new TeacherDto();
        teacherDto1.setTeacherName(teacherDto.getTeacherName());
        Dept dept = this.deptRepository.findById(deptId).orElseThrow();
        teacherDto1.setDept(dept);
        User user = this.userRepository.findById(userId).orElseThrow();
        teacherDto1.setUser(user);
        teacherRepository.save(teacherDto1);
        return teacherDto1;










    }

    @Override
    public TeacherDto viewTeacherById(Integer teacherId) {
        return null;
    }

    @Override
    public TeacherDto viewTeacher() {
        return null;
    }
}
