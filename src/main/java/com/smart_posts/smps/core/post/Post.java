package com.smart_posts.smps.core.post;

import com.smart_posts.smps.core.post.dto.PostDto;
import com.smart_posts.smps.core.user.User;
import com.smart_posts.smps.core.user.dto.UserDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

    private String title;

    private String body;

    public Post(final String title,
                final String body,
                final Long userId) {
        this.title = title;
        this.body = body;
        this.userId = userId;
    }

    public static Post from(final PostDto postDto) {
        return new Post(
                postDto.getTitle(),
                postDto.getBody(),
                postDto.getUserId()
        );
    }
}