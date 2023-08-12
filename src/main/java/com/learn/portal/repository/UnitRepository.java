package com.learn.portal.repository;

import com.learn.portal.entites.Subject;
import com.learn.portal.entites.Unit;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository<Unit, Integer> {
	
	List<Unit> findBySubject(Subject subject);
}
