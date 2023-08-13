package com.learn.portal.controllers;

import com.learn.portal.dto.UserDto;
import com.learn.portal.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        UserDto createdUser = this.userService.createUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserDto userDto) {
        return this.userService.loginUser(userDto);
    }

}
