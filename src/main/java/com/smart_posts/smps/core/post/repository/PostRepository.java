package com.smart_posts.smps.core.post.repository;

import com.smart_posts.smps.core.post.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
