package com.vamsi.todo.service;

import com.vamsi.todo.domain.Project;
import com.vamsi.todo.model.CreateProjectRequest;
import com.vamsi.todo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public Project createProject(CreateProjectRequest request) {
        Project project = new Project();
        project.setProjectName(request.getProjectName());
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }

    public Optional<Project> getProject(String projectId){
        return projectRepository.findById(projectId);
    }

}
