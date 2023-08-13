package com.learn.portal.service;

import com.learn.portal.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserService {

    UserDto createUser(UserDto userDto);
	UserDto updateUser(UserDto user, Integer userId);
    UserDto getUserById(Integer userId);

    ResponseEntity<?> loginUser(UserDto userDto);
}
