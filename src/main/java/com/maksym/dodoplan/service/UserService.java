package com.maksym.dodoplan.service;

import com.maksym.dodoplan.model.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserDto getById(Long id);

    List<UserDto> getAll();
    
    UserDto save (UserDto userDto);

    void delete (UserDto userDto);

}
