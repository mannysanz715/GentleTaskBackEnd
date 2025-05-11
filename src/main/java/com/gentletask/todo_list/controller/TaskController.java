package com.gentletask.todo_list.controller;

import com.gentletask.todo_list.model.Task;
import com.gentletask.todo_list.model.Category;
import com.gentletask.todo_list.repository.TaskRepository;
import com.gentletask.todo_list.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;



@RestController

@RequestMapping("/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

  @Autowired
  private TaskRepository taskRepository;
  @Autowired
  private CategoryRepository categoryRepository;

  
  
  //Retrieve all Tasks Created
  @GetMapping
  public List<Task> getTasks() {
    List<Task> tasks = taskRepository.findAll();
    return tasks;
  }



  //Create New Task
  @PostMapping
  public Task createTask(@RequestBody Task task){
    //Add time created 
    LocalDateTime createdAt = LocalDateTime.now();
    String formatted = createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    task.setTimeCreated(formatted);
   
    //Add Category to the task
    String categoryIdString = task.getCategoryId();
    Optional<Category> categoryOpt = categoryRepository.findById(categoryIdString);
      //If there is a correct category that is retrieved
      //Add that category to the task
      if(categoryOpt.isPresent())
      {
        task.setCategory(categoryOpt.get());
      }   

      //Return task created / create task document in database
    return taskRepository.save(task);
  }



  //Retrieve by ID
  @GetMapping("/{id}")
  public Optional<Task> getTaskById(@PathVariable String id) {
      return taskRepository.findById(id);
  }

  @DeleteMapping("/{id}")
  public void deleteTodo(@PathVariable String id){
    taskRepository.deleteById(id);
  }
  
  //Updating Task
  @PutMapping("/{id}")
  public Task updateTask(@PathVariable String id, @RequestBody Task updatedTask) {
      //TODO: process PUT request
      Optional<Task> optionalTask = taskRepository.findById(id);
      if(optionalTask.isPresent()){
      Task task = optionalTask.get();
      task.setTaskTitle(updatedTask.getTaskTitle());
      task.setTaskStatus(updatedTask.getTaskStatus());
      task.setTaskDeadline(updatedTask.getTaskDeadline());
      task.setCategoryId(updatedTask.getCategoryId());
      task.setTaskRecurring(updatedTask.getTaskRecurring());
      task.setTaskDescription(updatedTask.getTaskDescription());
      task.setTimeCreated(updatedTask.getTimeCreated());
      return taskRepository.save(task);

    }
    return null;

  }

}
