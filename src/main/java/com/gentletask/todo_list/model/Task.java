package com.gentletask.todo_list.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

import java.util.Optional;

import org.springframework.data.annotation.Id;


@Data
@Document(collection = "task")
public class Task {
  @Id
  private String id;
  private String taskTitle;
  private String taskDescription;
  private String timeCreated;
  private String taskDeadline;
  private String taskRecurring;
  private String taskStatus;
  private String categoryId;
  private Category category;
}

