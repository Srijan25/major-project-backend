package com.learn.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.portal.entites.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
