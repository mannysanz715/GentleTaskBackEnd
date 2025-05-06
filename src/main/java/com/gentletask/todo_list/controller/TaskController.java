package com.gentletask.todo_list.controller;

import com.gentletask.todo_list.model.Task;
import com.gentletask.todo_list.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "*")


public class TaskController {

  @Autowired
  private TaskRepository taskRepository;


//Retrieve all Tasks Created
  @GetMapping
  public List<Task> getTasks() {
      return taskRepository.findAll();
  }

  //Create New Task

  @PostMapping
  public Task createTask(@RequestParam Task task){
    return taskRepository.save(task);
  }


  //Retrieve by ID
  @GetMapping("/{id}")
  public Optional<Task> getTaskById(@RequestParam String param) {
      return taskRepository.findById(param);
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
      task.setCategory(updatedTask.getCategory());
      task.setTaskRecurring(updatedTask.getTaskRecurring());
      task.setTaskDescription(updatedTask.getTaskDescription());
      task.setTimeCreated(updatedTask.getTimeCreated());
      return taskRepository.save(task);

    }
    return null;

  }
  
  



}
