package com.gentletask.todo_list.repository;


import com.gentletask.todo_list.model.Category;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface CategoryRepository extends MongoRepository<Category, String> {

  Optional<Category> findById(Category category);
  
}