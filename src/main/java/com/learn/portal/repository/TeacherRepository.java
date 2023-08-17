package com.learn.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.portal.entites.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
