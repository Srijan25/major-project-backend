package com.learn.portal.controllers;

import com.learn.portal.dto.UserDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @PostMapping("/signup")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        userDto.setRole("USER");
//        UserDto createdUser = this.userService.createUser(userDto);

//        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        return new ResponseEntity("ok", HttpStatus.OK);
    }

}
