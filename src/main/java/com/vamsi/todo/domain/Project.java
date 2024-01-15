package com.vamsi.todo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("project")
public class Project {
    @Id
    private String projectId;
    private String projectName;
}
