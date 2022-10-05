package com.example.ticketmvc.controller;


import com.example.ticketmvc.dto.ProjectDTO;
import com.example.ticketmvc.service.ProjectService;
import com.example.ticketmvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/project")
public class ProjectController {

  ProjectService projectService;
  UserService userService;
  public ProjectController(ProjectService projectService, UserService userService){
      this.projectService=projectService;
      this.userService=userService;
  }

    @GetMapping("/create")
     public String getProjectCreate(Model model){
        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("projects",projectService.findAll());
        model.addAttribute("managers",userService.findManagers());
         return "/project/create";
     }

     @PostMapping("/create")
     public String createProject(ProjectDTO project){

      projectService.save(project);

      return "redirect:/project/create";
     }

     @GetMapping("/delete/{projectCode}")
     public String deleteProject(@PathVariable("projectCode")String projectCode ){
           projectService.deleteById(projectCode);

      return "redirect:/project/create";
     }
     @GetMapping("/complete/{projectCode}")
     public String completeProject(@PathVariable("projectCode") String projectCode){



         return "redirect:/project/create";
     }

     @GetMapping("/update/{projectCode}")
     public String editProject(@PathVariable("projectCode") String projectCode, Model model){

         model.addAttribute("project", projectService.findById(projectCode));
         model.addAttribute("projects",projectService.findAll());
         model.addAttribute("managers",userService.findManagers());
      return "/project/update";
     }

    @PostMapping("/update")
    public String updateProject(ProjectDTO project){

        projectService.update(project);

        return "redirect:/project/create";
    }
}
