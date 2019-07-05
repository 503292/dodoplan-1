package com.maksym.dodoplan.service.impl;

import com.maksym.dodoplan.exception.RoleNotFoundException;
import com.maksym.dodoplan.model.Role;
import com.maksym.dodoplan.model.dto.RoleDto;
import com.maksym.dodoplan.repository.RoleRepository;
import com.maksym.dodoplan.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public RoleDto save(RoleDto roleDto) {

        return Optional.of(roleDto)
                .map(e -> modelMapper.map(e, Role.class))
                .map(e -> roleRepository.save(e))
                .map(e -> modelMapper.map(e, RoleDto.class))
                .orElseThrow(() -> new RoleNotFoundException("RoleDto is null. Nothing to save"));
    }

    @Override
    public void delete(RoleDto roleDto) {

        Role role = Optional.of(roleDto)
                .map(e -> modelMapper.map(e, Role.class))
                .orElseThrow(() -> new RoleNotFoundException("RoleDto is null. Nothing to save"));

        roleRepository.delete(role);
    }

    @Override
    public RoleDto findById(Long id) {

        return roleRepository.findById(id)
                .map(e -> modelMapper.map(e, RoleDto.class))
                .orElseThrow(() -> new RoleNotFoundException("Role not found with id " + id));
    }

    @Override
    public List<RoleDto> findAll() {

        return roleRepository.findAll().stream()
                .filter(Objects::nonNull)
                .map(e -> modelMapper.map(e, RoleDto.class))
                .collect(Collectors.toList());
    }
}
