package com.shigal.springsecuritydemoapp.repository;/*
 *
 * @author Lawshiga
 *
 */

import com.shigal.springsecuritydemoapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);
}
