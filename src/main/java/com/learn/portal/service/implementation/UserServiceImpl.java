package com.learn.portal.service.implementation;

import com.learn.portal.dto.UserDto;
import com.learn.portal.entites.User;
import com.learn.portal.jwt.JwtTokenProvider;
import com.learn.portal.repository.UserRepository;
import com.learn.portal.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;


    @Override
    public ResponseEntity<String> createUser(UserDto userDto) {
        if(this.userRepository.findByEmailId(userDto.getEmailId()).isPresent()) {
            return ResponseEntity.badRequest().body("Email Id already exists");
        }
        User user = this.dtoToUser(userDto);
        user.setPassword(this.passwordEncoder.encode(userDto.getPassword()));
        User savedUser = this.userRepository.save(user);
        return ResponseEntity.ok("User created successfully");
    }

    @Override
    public ResponseEntity<?> loginUser(@RequestBody UserDto userDto) {
        try {
            var authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(userDto.getEmailId(), userDto.getPassword()));
            String token = jwtTokenProvider.createToken(authentication);

            UserDto user = this.getUserByEmail(userDto.getEmailId());
            Map<String, Object> response = new HashMap<>();
            response.put("userId", user.getUserId());
            response.put("name", user.getName());
            response.put("token", token);
            response.put("role", user.getRole());

            return ResponseEntity.ok(response.toString());

        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().body("Invalid username/password supplied");
        }
    }
    private User dtoToUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmailId(userDto.getEmailId());
        user.setRole(userDto.getRole());
        return user;
    }

    private UserDto userToDto(User user) {
        ModelMapper mapper = new ModelMapper();
        UserDto userDto = mapper.map(user, UserDto.class);
        return userDto;
    }

    private UserDto getUserByEmail(String emailId) {
        User user = this.userRepository.findByEmailId(emailId)
        .orElseThrow(() -> new RuntimeException("User not found with email id: " + emailId));
        return this.userToDto(user);
    }
}
