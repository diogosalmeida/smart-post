package com.smart_posts.smps.core.user.repositoty;

import com.smart_posts.smps.core.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}