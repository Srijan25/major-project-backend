package com.learn.portal.service.implementation;

import com.learn.portal.dto.StudentDto;
import com.learn.portal.entites.Student;
import com.learn.portal.entites.Teacher;
import com.learn.portal.repository.DeptRepository;
import com.learn.portal.repository.StudentRepository;
import com.learn.portal.repository.UserRepository;
import com.learn.portal.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DeptRepository deptRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public StudentDto createStudent(StudentDto studentDto, Integer deptId, Integer userId) {
        Student student = this.modelMapper.map(studentDto, Student.class);
        student.setSemester(studentDto.getSemester());
        student.setStudentRoll(studentDto.getStudentRoll());
        student.setUser(this.userRepository.findById(userId).orElseThrow());
        student.setDept(this.deptRepository.findById(deptId).orElseThrow());
        Student savedStudent = this.studentRepository.save(student);
        return this.modelMapper.map(savedStudent, StudentDto.class);

    }

    @Override
    public StudentDto viewStudentById(Integer studentId) {
         return null;
     }

    @Override
    public StudentDto viewStudent() {
        return null;
    }
}
