package com.learn.portal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.portal.entites.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmailId(String emailId);

    User findByEmailIdAndPassword(String emailId, String password);

    List<User> findByRole(String role);

    List<User> findAllByRole(String role);

}
