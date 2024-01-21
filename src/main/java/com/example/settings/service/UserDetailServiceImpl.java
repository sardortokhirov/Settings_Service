package com.example.settings.service;

import com.example.settings.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Date-21/01/2024
 * By Sardor Tokhirov
 */

@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private final static String USER_NOT_FOUND="user with %s username or email not found";
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElse(userRepository.findByUserName(username).orElseThrow(()->new UsernameNotFoundException(String.format(USER_NOT_FOUND,username))));
    }
}
