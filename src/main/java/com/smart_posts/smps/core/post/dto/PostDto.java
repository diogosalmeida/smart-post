package com.smart_posts.smps.core.post.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smart_posts.smps.core.post.Post;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostDto {
    private String title;
    private String body;
    @JsonProperty("user_id")
    private Long userId;

    public static Post toPost(final PostDto postDto) {
        return new Post(
                postDto.getTitle(),
                postDto.getBody(),
                postDto.getUserId()
        );
    }
}
