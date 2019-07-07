package com.maksym.dodoplan.service.impl;

import com.maksym.dodoplan.exception.UserNotFoundException;
import com.maksym.dodoplan.model.Chapter;
import com.maksym.dodoplan.model.Role;
import com.maksym.dodoplan.model.Task;
import com.maksym.dodoplan.model.User;
import com.maksym.dodoplan.model.dto.UserDto;
import com.maksym.dodoplan.repository.UserRepository;
import com.maksym.dodoplan.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service(value = "userService")
public class UserServiceImpl implements UserService, UserDetailsService {

    //TODO implement UserDto to service
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(s)
                .orElseThrow(() -> new UserNotFoundException("UserDto with login: " + s + " not found"));

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
                .orElseThrow(() -> new UsernameNotFoundException("UserDto with id: " + id + " not found"));
    }



    @Override
    public UserDto getById(Long id) {
         return userRepository.findById(id)
                .map(e -> modelMapper.map(e, UserDto.class))
                .orElseThrow(() -> new UserNotFoundException("Username with id " + id + "not found"));
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .filter(Objects::nonNull)
                .map(e -> modelMapper.map(e, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto save(UserDto userDto) {
        User user = Optional.of(userDto)
                .map(e -> modelMapper.map(e, User.class))
                .orElseThrow(() -> new UserNotFoundException("UserDto is null Object. Nothing to save"));
        return modelMapper.map(userRepository.save(user), UserDto.class);
    }

    @Override
    public void delete(UserDto userDto) {
        User user = Optional.of(userDto)
                .map(e -> modelMapper.map(e, User.class))
                .orElseThrow(() -> new UserNotFoundException("UserDto is null. Nothing to delete"));

        userRepository.delete(user);
    }
}
