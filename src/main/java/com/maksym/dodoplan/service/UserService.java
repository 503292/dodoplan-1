package com.maksym.dodoplan.service;

import com.maksym.dodoplan.model.dto.UserDto;
import java.util.List;


public interface UserService {

    UserDto getById(Long id);

    List<UserDto> findAll();

    UserDto save (UserDto userDto);

    UserDto update(Long id, UserDto userDto);

    void delete (UserDto userDto);

}
