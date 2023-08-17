package com.learn.portal.controllers;

import com.learn.portal.dto.UserDto;
import com.learn.portal.service.FileService;
import com.learn.portal.service.UserService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
    public ResponseEntity<UserDto> createUser( @RequestBody UserDto userDto) {
        UserDto createdUser = this.userService.createUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);

    }

    @GetMapping("/usersByRole/{role}")
    public ResponseEntity<List<UserDto>> getAllUsersByRole(@PathVariable String role){
    	List<UserDto> userDtos = this.userService.getAllUsersByRole(role);
    	return new ResponseEntity<List<UserDto>>(userDtos, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserDto userDto) {
        return this.userService.loginUser(userDto);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId){
        UserDto userDto = this.userService.getUserById(userId);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
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

    @GetMapping("/allUsers")
    public ResponseEntity<List<UserDto>> viewAllUsers(){
        List<UserDto> userDtos = this.userService.getAllUsers();
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

}
