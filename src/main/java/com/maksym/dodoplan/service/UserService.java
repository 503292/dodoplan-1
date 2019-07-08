package com.maksym.dodoplan.service;

import com.maksym.dodoplan.model.dto.UserDto;
import java.util.List;


public interface UserService {
    //TODO FIX rechange to get to find
    UserDto getById(Long id);

    List<UserDto> findAll();

    UserDto save (UserDto userDto);

    void delete (UserDto userDto);

}
