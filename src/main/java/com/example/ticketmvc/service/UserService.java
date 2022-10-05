package com.example.ticketmvc.service;


import com.example.ticketmvc.dto.UserDTO;

import java.util.List;

public interface UserService extends CrudService<UserDTO,String> {

   List<UserDTO>findManagers();
   List<UserDTO>findEmployees();
}
