package com.learn.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.portal.entites.Events;

public interface EventsRepository extends JpaRepository<Events, Integer> {
}
