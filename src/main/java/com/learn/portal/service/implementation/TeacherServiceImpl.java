package com.learn.portal.service.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.portal.dto.TeacherDto;
import com.learn.portal.entites.Dept;
import com.learn.portal.entites.Teacher;
import com.learn.portal.entites.User;
import com.learn.portal.repository.DeptRepository;
import com.learn.portal.repository.TeacherRepository;
import com.learn.portal.repository.UserRepository;
import com.learn.portal.service.TeacherService;

@Service

public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DeptRepository deptRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public TeacherDto createTeacher(TeacherDto teacherDto, Integer deptId, Integer userId) {
        Teacher teacher = this.modelMapper.map(teacherDto, Teacher.class);
        User user = this.userRepository.findById(userId).orElseThrow();
        teacher.setUser(user);
        Dept dept = this.deptRepository.findById(deptId).orElseThrow();
        teacher.setDept(dept);
        Teacher savedTeacher = this.teacherRepository.save(teacher);
        return this.modelMapper.map(savedTeacher, TeacherDto.class);


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
