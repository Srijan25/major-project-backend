package com.learn.portal.controllers;

import com.learn.portal.dto.UserDto;
import com.learn.portal.service.FileService;
import com.learn.portal.service.UserService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    
    @Autowired
    private FileService fileService;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        UserDto createdUser = this.userService.createUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserDto userDto) {
        return this.userService.loginUser(userDto);
    }
    
    @PostMapping("/user/img_upload/{userId}")
	public ResponseEntity<UserDto> uploadProductImage(@RequestParam("image") MultipartFile image,
			@PathVariable Integer userId) throws IOException {

		UserDto userDto = this.userService.getUserById(userId);
		String fileName = this.fileService.uploadImage(image);

		userDto.setUserImage(fileName);

		UserDto updatedUser= this.userService.updateUser(userDto, userId);
		return new ResponseEntity<UserDto>(updatedUser, HttpStatus.OK);
	}
    
    @GetMapping(value = "/user/image/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
	public void viewImage(@PathVariable String imageName, HttpServletResponse response) throws IOException {

		InputStream resource = this.fileService.getResource(imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(resource, response.getOutputStream());
	}

}
