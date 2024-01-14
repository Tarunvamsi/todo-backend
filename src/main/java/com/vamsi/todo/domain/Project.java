package com.vamsi.todo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Project {
    @Id
    private String ProjectId;
    private String ProjectName;
}
