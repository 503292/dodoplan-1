package com.maksym.dodoplan.service.impl;

import com.maksym.dodoplan.exception.UserNotFoundException;
import com.maksym.dodoplan.model.User;
import com.maksym.dodoplan.repository.UserRepository;
import com.maksym.dodoplan.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service(value = "userService")
public class UserServiceImpl implements UserService, UserDetailsService {

    //TODO implement UserDto to service
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(s)
                .orElseThrow(() -> new UserNotFoundException("User with login: " + s + " not found"));

        if (Objects.isNull(user)) {
            log.error("Invalid username or password");
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        //todo add correct authou
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
    }

    public List<GrantedAuthority> getAuthority(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });

        return authorities;
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User with id: " + id + " not found"));
    }
}
