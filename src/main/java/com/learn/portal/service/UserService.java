package com.learn.portal.service;

import com.learn.portal.dto.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);
	UserDto updateUser(UserDto user, Integer userId);
    UserDto getUserById(Integer userId);

    ResponseEntity<?> loginUser(UserDto userDto);
    List<UserDto> getAllUsers();

    List<UserDto> getAllUsersByRole(String role);

}
