package com.learn.portal.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.portal.entites.Announcement;

public interface AccouncementRepository extends JpaRepository<Announcement, Integer> {
}
