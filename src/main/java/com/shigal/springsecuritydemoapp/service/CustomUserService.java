package com.shigal.springsecuritydemoapp.service;/*
 *
 * @author Lawshiga
 *
 */

import com.shigal.springsecuritydemoapp.model.User;
import com.shigal.springsecuritydemoapp.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userDetailsRepository.findUserByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("User not found with username " + username);
        }
        else {
            return user;
        }
    }
}
