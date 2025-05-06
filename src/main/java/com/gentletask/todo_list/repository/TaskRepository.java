package com.gentletask.todo_list.repository;

import com.gentletask.todo_list.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface TaskRepository extends MongoRepository<Task, String> {
  
}
