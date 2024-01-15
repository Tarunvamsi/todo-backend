package com.vamsi.todo.repository;

import com.vamsi.todo.domain.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
}
