package com.smart_posts.smps.core.post.services;

import com.smart_posts.smps.core.post.dto.PostDto;
import com.smart_posts.smps.core.post.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    public void createPost(final PostDto postDto) {
       postRepository.save(postDto.toPost(postDto));
    }
}
