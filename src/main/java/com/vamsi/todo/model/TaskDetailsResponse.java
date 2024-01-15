package com.vamsi.todo.model;

import com.vamsi.todo.domain.Task;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class TaskDetailsResponse {
    private String taskId;
    private String taskName;
    private String assigneeId;
    private String assigneeName;
    private LocalDateTime startTime;
    private String projectId;
    private String projectName;

    public static TaskDetailsResponse from(Task task) {
        return TaskDetailsResponse.builder()
                .taskId(task.getTaskId())
                .taskName(task.getTaskName())
                .projectId(task.getProject().getProjectId())
                .projectName(task.getProject().getProjectName())
                .assigneeId(task.getAssignee().getUserId())
                .assigneeName(task.getAssignee().getUserName())
                .startTime(task.getStartTime())
                .build();
    }
}

