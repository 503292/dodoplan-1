package com.maksym.dodoplan.service;

import com.maksym.dodoplan.model.dto.RoleDto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface RoleService {

    RoleDto save(RoleDto roleDto);

    void delete(RoleDto roleDto);

    RoleDto findById(Long id);

    List<RoleDto> findAll();
}
