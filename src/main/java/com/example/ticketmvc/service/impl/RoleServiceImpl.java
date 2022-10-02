package com.example.ticketmvc.service.impl;


import com.example.ticketmvc.dto.RoleDTO;
import com.example.ticketmvc.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends AbstractMapService<RoleDTO,Long> implements RoleService {


    @Override
    public RoleDTO save(RoleDTO object) {
        return super.save(object.getId(), object);
    }

    @Override
    public List<RoleDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }


    @Override
    public RoleDTO findById(Long id) {
        return super.findById(id);
    }
}