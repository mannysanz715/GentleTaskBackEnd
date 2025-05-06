package com.gentletask.todo_list.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "category")
public class Category {
  @Id
  
  private String id;
  private String categoryName;
  private int priorityLevel;
  private int energyLevel;
  

}
