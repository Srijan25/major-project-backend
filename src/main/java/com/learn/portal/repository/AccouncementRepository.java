package com.learn.portal.repository;
import com.learn.portal.entites.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccouncementRepository extends JpaRepository<Announcement, Integer> {
}
