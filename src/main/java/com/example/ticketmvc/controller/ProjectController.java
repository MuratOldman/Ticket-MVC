package com.example.ticketmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("project")
public class ProjectController {



     @GetMapping("create")
     public String getProjectCreate(){

         return "project/create";
     }

     @PostMapping("save")
     public String saveProject(){



         return "project/create";

     }
}
