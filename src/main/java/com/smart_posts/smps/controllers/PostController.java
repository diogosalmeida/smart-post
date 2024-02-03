package com.smart_posts.smps.controllers;

import com.smart_posts.smps.domain.Post;
import com.smart_posts.smps.cases.post.dto.PostDto;
import com.smart_posts.smps.cases.post.PostService;
import com.smart_posts.smps.cases.user.UserService;
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
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {

    private final PostService postService;
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        if(userService.findUserById(postDto.getUserId())) {
            postService.createPost(postDto);
            return new ResponseEntity<>(postDto, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(postDto, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Post>> getPosts() {
        final var posts = postService.findAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
}

