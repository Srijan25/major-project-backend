package com.learn.portal.repository;

import com.learn.portal.entites.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Integer> {
}
