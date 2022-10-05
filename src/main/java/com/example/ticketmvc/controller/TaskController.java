package com.example.ticketmvc.controller;

import com.example.ticketmvc.dto.TaskDTO;
import com.example.ticketmvc.service.ProjectService;
import com.example.ticketmvc.service.TaskService;
import com.example.ticketmvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {

    TaskService taskService;
    ProjectService projectService;
    UserService userService;

    public TaskController(TaskService taskService, ProjectService projectService, UserService userService) {
        this.taskService = taskService;
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String get(Model model){

        model.addAttribute("task", new TaskDTO());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("tasks", taskService.findAll());
        model.addAttribute("employees", userService.findEmployees());


        return "/task/create";
    }


    @PostMapping("/create")
    public String insertTask(TaskDTO task) {
        taskService.save(task);
        return "redirect:/task/create";
    }


    @GetMapping("/update/{taskId}")
    public String editTask(@PathVariable("taskId") Long taskId, Model model) {

        model.addAttribute("task", taskService.findById(taskId));
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("employees", userService.findEmployees());
        model.addAttribute("tasks", taskService.findAll());

        return "task/update";

    }

//    @PostMapping("/update/{taskId}")
//    public String updateTask(@PathVariable("taskId") Long taskId, TaskDTO task) {
//        task.setId(taskId);
//        taskService.update(task);
//        return "redirect:/task/create";
//    }

    @PostMapping("/update/{id}")
    public String updateTask(TaskDTO task) {
        taskService.update(task);
        return "redirect:/task/create";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(TaskDTO task){
        taskService.deleteById(task.getId());
        return "redirect:/task/create";
    }
}
