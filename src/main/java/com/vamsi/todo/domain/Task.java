package com.vamsi.todo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@Setter
public class Task {
    @Id
    private String taskId;
    private String taskName;
    private User assignee;
    private LocalDateTime startTime;
    private Project project;
}
