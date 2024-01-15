package com.vamsi.todo.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateTaskRequest {
    @NotEmpty
    private String taskName;

    @NotEmpty
    private String assigneeId;

    @NotEmpty
    private LocalDateTime startTime;

    @NotEmpty
    private String projectId;
}
