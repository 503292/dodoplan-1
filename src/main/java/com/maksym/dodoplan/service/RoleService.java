package com.maksym.dodoplan.service;

import com.maksym.dodoplan.model.dto.RoleDto;
import java.util.List;

public interface RoleService {

    RoleDto save(RoleDto roleDto);

    void delete(RoleDto roleDto);

    RoleDto findById(Long id);

    List<RoleDto> findAll();
}
