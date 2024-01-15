package com.vamsi.todo.controller;

import com.vamsi.todo.domain.Task;
import com.vamsi.todo.model.CreateTaskRequest;
import com.vamsi.todo.model.TaskDetailsResponse;
import com.vamsi.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping("/tasks")
    public List<TaskDetailsResponse> getAllTasks() {
        return taskService.getAllTasks();
    }

    @RequestMapping(value = { "/tasks/{taskId}" }, method = { RequestMethod.GET })
    public TaskDetailsResponse getTask(@PathVariable String taskId) {
        return taskService.getTask(taskId);
    }

    @PostMapping("/tasks")
    public TaskDetailsResponse createTask(@RequestBody CreateTaskRequest request) {
        return taskService.createTask(request);
    }

    @RequestMapping(value = { "/tasks/{taskId}" }, method = { RequestMethod.DELETE })
    public void deleteTask(@PathVariable String taskId){
        taskService.deleteTask(taskId);
    }

}
