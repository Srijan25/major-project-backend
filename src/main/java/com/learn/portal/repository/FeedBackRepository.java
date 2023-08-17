package com.learn.portal.repository;

import com.learn.portal.entites.FeedBack;
import com.learn.portal.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedBackRepository extends JpaRepository<FeedBack, Integer>{
    List<FeedBack> findByUser(Integer userId);
}
