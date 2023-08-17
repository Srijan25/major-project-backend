package com.learn.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.portal.entites.Dept;
import com.learn.portal.entites.Subject;
import com.learn.portal.entites.User;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
	
	List<Subject> findByDeptAndSemester(Dept dept, Integer semester);

	List<Subject> findByTeacher(User teacher);

}
