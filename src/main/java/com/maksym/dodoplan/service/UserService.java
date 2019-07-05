package com.maksym.dodoplan.service;

import com.maksym.dodoplan.model.User;
import com.maksym.dodoplan.model.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto save(UserDto userDto);

    UserDto update(UserDto userDto);

    UserDto delete(UserDto userDto);

    User findById(Long id);

    List<UserDto> findAllUser();


}
