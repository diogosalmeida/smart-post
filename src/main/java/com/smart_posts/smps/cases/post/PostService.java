package com.smart_posts.smps.cases.post;

import com.smart_posts.smps.domain.Post;
import com.smart_posts.smps.cases.post.dto.PostDto;
import com.smart_posts.smps.infrastructure.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    public void createPost(final PostDto postDto) {
       postRepository.save(PostDto.toPost(postDto));
    }

    public List<Post> findAllPosts() {
        return StreamSupport
                .stream(postRepository.findAll().spliterator(), false)
                .toList();
    }
}
