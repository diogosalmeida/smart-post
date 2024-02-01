package com.smart_posts.smps.controllers;

import com.smart_posts.smps.core.post.dto.PostDto;
import com.smart_posts.smps.core.post.services.PostService;
import com.smart_posts.smps.core.user.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {

    private final PostService postService;
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        postService.createPost(postDto);
        if(userService.findUserById(postDto.getUserId())) {
            return new ResponseEntity<>(postDto, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(postDto, HttpStatus.NOT_FOUND);
    }
}

