package com.vamsi.todo.controller;

import com.vamsi.todo.domain.Project;
import com.vamsi.todo.model.CreateProjectRequest;
import com.vamsi.todo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PostMapping("/projects")
    public Project createProject(@RequestBody CreateProjectRequest request) {
        return projectService.createProject(request);
    }

    @GetMapping("/projects/{projectId}")
    public Optional<Project> getProject(@PathVariable String projectId){
        return projectService.getProject(projectId);
    }
}
