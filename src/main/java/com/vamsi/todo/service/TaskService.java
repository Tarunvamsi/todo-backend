package com.vamsi.todo.service;

import com.vamsi.todo.domain.Project;
import com.vamsi.todo.domain.Task;
import com.vamsi.todo.domain.User;
import com.vamsi.todo.exception.BadRequestException;
import com.vamsi.todo.model.CreateTaskRequest;
import com.vamsi.todo.model.TaskDetailsResponse;
import com.vamsi.todo.repository.ProjectRepository;
import com.vamsi.todo.repository.TaskRepository;
import com.vamsi.todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    UserRepository userRepository;

    public List<TaskDetailsResponse> getAllTasks() {
        List<Task> taskList = taskRepository.findAll();
        return taskList.stream().map(TaskDetailsResponse::from).collect(Collectors.toList());
    }

    public TaskDetailsResponse createTask(CreateTaskRequest request) {
        Optional<Project> project = projectRepository.findById(request.getProjectId());
        Optional<User> user = userRepository.findById(request.getAssigneeId());

        // Validation
        validateTaskAsigneeAndProject(project, user);

        Task task = new Task();
        task.setTaskName(request.getTaskName());
        task.setStartTime(request.getStartTime());
        task.setProject(project.get());
        task.setAssignee(user.get());

        task = taskRepository.save(task);

        return TaskDetailsResponse.from(task);

    }

    private void validateTaskAsigneeAndProject(Optional<Project> project, Optional<User> user) {
        String errorMessage = null;


        if (project.isEmpty() && user.isEmpty()) {
            errorMessage = "Invalid project Id and user Id";
        } else if (project.isEmpty()) {
            errorMessage = "Invalid project Id";
        } else if (user.isEmpty()) {
            errorMessage = "Invalid user Id";
        }

        if (errorMessage != null) {
            throw new BadRequestException(errorMessage);
        }
    }

    public void deleteTask(String taskId) {
        taskRepository.deleteById(taskId);
    }

    public TaskDetailsResponse getTask(String taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new BadRequestException("Task not found."));
        return TaskDetailsResponse.from(task);
    }
}
