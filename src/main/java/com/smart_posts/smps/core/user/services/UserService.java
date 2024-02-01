package com.smart_posts.smps.core.user.services;

import com.smart_posts.smps.core.user.User;
import com.smart_posts.smps.core.user.dto.UserDto;
import com.smart_posts.smps.core.user.repositoty.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void createUser(final UserDto userDto) {
        final var user = UserDto.toUser(userDto);
        userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return StreamSupport
                .stream(userRepository.findAll().spliterator(), false).toList();
    }

    public boolean findUserById(final Long userId) {
         return userRepository.findById(userId).isPresent();
    }
}
