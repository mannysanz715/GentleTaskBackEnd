package com.gentletask.todo_list.controller;

import com.gentletask.todo_list.model.Category;
import com.gentletask.todo_list.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController

@RequestMapping("/category")
@CrossOrigin(origins = "*")
public class CategoryController {
  
  @Autowired

  private CategoryRepository categoryRepository;


  @GetMapping
  public List<Category> getCategories(){
    return categoryRepository.findAll();
  }


  @GetMapping("/{id}")

   public Optional<Category> getCategoryById(@RequestParam String param) {
      return categoryRepository.findById(param);
  }

  @PostMapping
  public Category createCategory(@RequestBody Category category) {
      //TODO: process POST request
      return categoryRepository.save(category);
  }
  

}
