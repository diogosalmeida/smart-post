package com.smart_posts.smps.controllers;

import com.smart_posts.smps.core.user.User;
import com.smart_posts.smps.core.user.dto.UserDto;
import com.smart_posts.smps.core.user.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(final @RequestBody UserDto postDto) {
        userService.createUser(postDto);
        return new ResponseEntity<>(postDto, HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public List<User> getUsers() {
        List<User> users = userService.findAllUsers();
        return ResponseEntity.ok(users).getBody();
    }
}
