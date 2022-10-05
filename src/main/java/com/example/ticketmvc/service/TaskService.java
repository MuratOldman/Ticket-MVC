package com.example.ticketmvc.service;


import com.example.ticketmvc.dto.TaskDTO;
import com.example.ticketmvc.dto.UserDTO;
import com.example.ticketmvc.enums.Status;

import java.util.List;

public interface TaskService extends CrudService<TaskDTO, Long> {

    List<TaskDTO> findTasksByManager(UserDTO manager);

    List<TaskDTO> findAllTasksByStatus(Status status);

    List<TaskDTO> findAllTasksByStatusIsNot(Status status);

    void updateStatus(TaskDTO task);

}
