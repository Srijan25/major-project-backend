package com.learn.portal.repository;

import com.learn.portal.entites.Events;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepository extends JpaRepository<Events, Integer> {
}
