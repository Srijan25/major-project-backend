package com.learn.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.portal.entites.FeedBack;
import com.learn.portal.entites.User;

public interface FeedBackRepository extends JpaRepository<FeedBack, Integer>{

	List<FeedBack> findByFeedBackFor(User feedBackFor);
}
