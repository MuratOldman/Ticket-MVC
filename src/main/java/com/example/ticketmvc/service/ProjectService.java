package com.example.ticketmvc.service;


import com.example.ticketmvc.dto.ProjectDTO;
import com.example.ticketmvc.dto.UserDTO;

import java.util.List;

public interface ProjectService extends CrudService<ProjectDTO, String> {

    void complete(ProjectDTO project);

    List<ProjectDTO> findAllNonCompletedProjects();

    List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager);

}
