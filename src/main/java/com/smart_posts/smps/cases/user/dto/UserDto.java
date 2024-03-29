package com.smart_posts.smps.cases.user.dto;

import com.smart_posts.smps.domain.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private String name;
    private String email;
    private String password;

    public static User toUser(final UserDto userDto) {
        return new User(
                userDto.getName(),
                userDto.getEmail(),
                userDto.getPassword()
        );
    }
}
