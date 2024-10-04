package com.todolist.todolist.controllers;

import com.todolist.todolist.models.Task;
import com.todolist.todolist.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTask(){
        return taskService.getAllTask();
    }
    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable Integer id){
        return taskService.getTaskById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Integer id){
        return taskService.deleteTask(id);
    }

    @PutMapping("/{id}")
    public String updateTask(@PathVariable Integer id, @RequestBody Task task){
        return taskService.updateTask(task, id);
    }

    @PutMapping("/{id}/state")
    public Task updateState(@PathVariable Integer id, @RequestBody Task task){
        return taskService.changeStateOfTaskById(task.isState(), id);
    }

    @GetMapping("/state")
    public List<Task> getTaskByStates(@RequestBody Task task){
        return taskService.getAllByState(task.isState());
    }
}
