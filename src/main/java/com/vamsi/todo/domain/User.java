package com.vamsi.todo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
@Getter
@Setter
public class User {
    @Id
    private String userId;
    private String userName;
}
