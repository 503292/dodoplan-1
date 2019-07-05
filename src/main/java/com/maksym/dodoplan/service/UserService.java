package com.maksym.dodoplan.service;

import com.maksym.dodoplan.model.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto getById(Long id);

    List<UserDto> getAllUsers();
    
    UserDto save (UserDto userDto);

    UserDto update (UserDto userDto);

    UserDto delete (UserDto userDto);

}
