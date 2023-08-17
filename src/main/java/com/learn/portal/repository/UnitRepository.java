package com.learn.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.portal.entites.Subject;
import com.learn.portal.entites.Unit;

public interface UnitRepository extends JpaRepository<Unit, Integer> {
	
	List<Unit> findBySubject(Subject subject);
}
