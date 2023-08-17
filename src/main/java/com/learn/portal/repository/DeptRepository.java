package com.learn.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.portal.entites.Dept;

public interface DeptRepository extends JpaRepository<Dept, Integer> {
}
