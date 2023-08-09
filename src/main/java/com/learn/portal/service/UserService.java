package com.learn.portal.service;

import com.learn.portal.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<String> createUser(UserDto userDto);

    ResponseEntity<?> loginUser(UserDto userDto);
}
