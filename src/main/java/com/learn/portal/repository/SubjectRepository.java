package com.learn.portal.repository;

import com.learn.portal.entites.Dept;
import com.learn.portal.entites.Subject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
	
	List<Subject> findByDeptAndSemester(Dept dept, Integer semester);

}
