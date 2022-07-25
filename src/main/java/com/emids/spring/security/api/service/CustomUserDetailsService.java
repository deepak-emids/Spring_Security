package com.emids.spring.security.api.service;

import com.emids.spring.security.api.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.emids.spring.security.api.model.User;

@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        CustomUserDetails customUserDetails = null;
        if (user != null) {
            customUserDetails = new CustomUserDetails();
            customUserDetails.setUser(user);
        } else {
            throw new UsernameNotFoundException("User not exist with name : " + username);
        }
        return customUserDetails;
    }
}
